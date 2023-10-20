import {Component, OnInit} from '@angular/core';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/commun/ProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CategorieProduitDto} from 'src/app/controller/model/commun/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/commun/CategorieProduitAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {StockDto} from 'src/app/controller/model/commun/Stock.model';
import {StockAdminService} from 'src/app/controller/service/admin/commun/StockAdmin.service';


@Component({
  selector: 'app-produit-list-admin',
  templateUrl: './produit-list-admin.component.html'
})
export class ProduitListAdminComponent extends AbstractListController<ProduitDto, ProduitCriteria, ProduitAdminService>  implements OnInit {

    fileName = 'Produit';

    categorieProduits: Array<CategorieProduitDto>;
    marques: Array<MarqueDto>;


    constructor( private produitService: ProduitAdminService  , private categorieProduitService: CategorieProduitAdminService, private marqueService: MarqueAdminService, private depotService: DepotAdminService, private stockService: StockAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadCategorieProduit();
        this.loadMarque();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'categorieProduit?.reference', header: 'Categorie produit'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'marque?.reference', header: 'Marque'},
            {field: 'prixAchatMoyen', header: 'Prix achat moyen'},
            {field: 'prixVente', header: 'Prix vente'},
        ];
    }


    public async loadCategorieProduit(){
       this.categorieProduitService.findAllOptimized().subscribe(categorieProduits => this.categorieProduits = categorieProduits, error => console.log(error))
    }
    public async loadMarque(){
       this.marqueService.findAllOptimized().subscribe(marques => this.marques = marques, error => console.log(error))
    }

	public initDuplicate(res: ProduitDto) {
        if (res.stocks != null) {
             res.stocks.forEach(d => { d.produit = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Categorie produit': e.categorieProduit?.reference ,
                 'Libelle': e.libelle ,
                'Marque': e.marque?.reference ,
                 'Prix achat moyen': e.prixAchatMoyen ,
                 'Prix vente': e.prixVente ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        //'Categorie produit': this.criteria.categorieProduit?.reference ? this.criteria.categorieProduit?.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Marque': this.criteria.marque?.reference ? this.criteria.marque?.reference : environment.emptyForExport ,
            'Prix achat moyen Min': this.criteria.prixAchatMoyenMin ? this.criteria.prixAchatMoyenMin : environment.emptyForExport ,
            'Prix achat moyen Max': this.criteria.prixAchatMoyenMax ? this.criteria.prixAchatMoyenMax : environment.emptyForExport ,
            'Prix vente Min': this.criteria.prixVenteMin ? this.criteria.prixVenteMin : environment.emptyForExport ,
            'Prix vente Max': this.criteria.prixVenteMax ? this.criteria.prixVenteMax : environment.emptyForExport ,
        }];
      }
}

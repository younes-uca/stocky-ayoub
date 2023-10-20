import {Component, OnInit} from '@angular/core';
import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitCriteria} from 'src/app/controller/criteria/entree/EntreeProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/entree/EntreeProduitItem.model';
import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitItemAdmin.service';


@Component({
  selector: 'app-entree-produit-list-admin',
  templateUrl: './entree-produit-list-admin.component.html'
})
export class EntreeProduitListAdminComponent extends AbstractListController<EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService>  implements OnInit {

    fileName = 'EntreeProduit';

    fournisseurs: Array<FournisseurDto>;
    collaborateurs: Array<CollaborateurDto>;


    constructor( private entreeProduitService: EntreeProduitAdminService  , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private fournisseurService: FournisseurAdminService, private entreeProduitItemService: EntreeProduitItemAdminService) {
        super(entreeProduitService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadFournisseur();
        this.loadCollaborateur();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateEntreeProduit', header: 'Date entree produit'},
            {field: 'total', header: 'Total'},
            {field: 'fournisseur?.reference', header: 'Fournisseur'},
            {field: 'collaborateur?.prenom', header: 'Collaborateur'},
        ];
    }


    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }
    public async loadCollaborateur(){
       this.collaborateurService.findAllOptimized().subscribe(collaborateurs => this.collaborateurs = collaborateurs, error => console.log(error))
    }

	public initDuplicate(res: EntreeProduitDto) {
        if (res.entreeProduitItems != null) {
             res.entreeProduitItems.forEach(d => { d.entreeProduit = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date entree produit': this.datePipe.transform(e.dateEntreeProduit , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                'Fournisseur': e.fournisseur?.reference ,
                 'Description': e.description ,
                'Collaborateur': e.collaborateur?.prenom ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date entree produit Min': this.criteria.dateEntreeProduitFrom ? this.datePipe.transform(this.criteria.dateEntreeProduitFrom , this.dateFormat) : environment.emptyForExport ,
            'Date entree produit Max': this.criteria.dateEntreeProduitTo ? this.datePipe.transform(this.criteria.dateEntreeProduitTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.reference ? this.criteria.fournisseur?.reference : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Collaborateur': this.criteria.collaborateur?.prenom ? this.criteria.collaborateur?.prenom : environment.emptyForExport ,
        }];
      }
}

import {Component, OnInit} from '@angular/core';
import {InventaireAdminService} from 'src/app/controller/service/admin/entree/InventaireAdmin.service';
import {InventaireDto} from 'src/app/controller/model/entree/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/entree/InventaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {InventaireItemDto} from 'src/app/controller/model/entree/InventaireItem.model';
import {InventaireItemAdminService} from 'src/app/controller/service/admin/entree/InventaireItemAdmin.service';


@Component({
  selector: 'app-inventaire-list-admin',
  templateUrl: './inventaire-list-admin.component.html'
})
export class InventaireListAdminComponent extends AbstractListController<InventaireDto, InventaireCriteria, InventaireAdminService>  implements OnInit {

    fileName = 'Inventaire';

    collaborateurs: Array<CollaborateurDto>;


    constructor( private inventaireService: InventaireAdminService  , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private inventaireItemService: InventaireItemAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadCollaborateur();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateInventaire', header: 'Date inventaire'},
            {field: 'collaborateur?.prenom', header: 'Collaborateur'},
        ];
    }


    public async loadCollaborateur(){
       this.collaborateurService.findAllOptimized().subscribe(collaborateurs => this.collaborateurs = collaborateurs, error => console.log(error))
    }

	public initDuplicate(res: InventaireDto) {
        if (res.inventaireItems != null) {
             res.inventaireItems.forEach(d => { d.inventaire = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date inventaire': this.datePipe.transform(e.dateInventaire , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
                'Collaborateur': e.collaborateur?.prenom ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date inventaire Min': this.criteria.dateInventaireFrom ? this.datePipe.transform(this.criteria.dateInventaireFrom , this.dateFormat) : environment.emptyForExport ,
            'Date inventaire Max': this.criteria.dateInventaireTo ? this.datePipe.transform(this.criteria.dateInventaireTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Collaborateur': this.criteria.collaborateur?.prenom ? this.criteria.collaborateur?.prenom : environment.emptyForExport ,
        }];
      }
}

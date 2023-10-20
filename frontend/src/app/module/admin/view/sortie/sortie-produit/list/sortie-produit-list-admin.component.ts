import {Component, OnInit} from '@angular/core';
import {SortieProduitAdminService} from 'src/app/controller/service/admin/sortie/SortieProduitAdmin.service';
import {SortieProduitDto} from 'src/app/controller/model/sortie/SortieProduit.model';
import {SortieProduitCriteria} from 'src/app/controller/criteria/sortie/SortieProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/sortie/SortieProduitItem.model';
import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/sortie/SortieProduitItemAdmin.service';


@Component({
  selector: 'app-sortie-produit-list-admin',
  templateUrl: './sortie-produit-list-admin.component.html'
})
export class SortieProduitListAdminComponent extends AbstractListController<SortieProduitDto, SortieProduitCriteria, SortieProduitAdminService>  implements OnInit {

    fileName = 'SortieProduit';

    collaborateurs: Array<CollaborateurDto>;


    constructor( private sortieProduitService: SortieProduitAdminService  , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private sortieProduitItemService: SortieProduitItemAdminService) {
        super(sortieProduitService);
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
            {field: 'dateSortieProduit', header: 'Date sortie produit'},
            {field: 'total', header: 'Total'},
            {field: 'collaborateur?.prenom', header: 'Collaborateur'},
        ];
    }


    public async loadCollaborateur(){
       this.collaborateurService.findAllOptimized().subscribe(collaborateurs => this.collaborateurs = collaborateurs, error => console.log(error))
    }

	public initDuplicate(res: SortieProduitDto) {
        if (res.sortieProduitItems != null) {
             res.sortieProduitItems.forEach(d => { d.sortieProduit = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date sortie produit': this.datePipe.transform(e.dateSortieProduit , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Description': e.description ,
                'Collaborateur': e.collaborateur?.prenom ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date sortie produit Min': this.criteria.dateSortieProduitFrom ? this.datePipe.transform(this.criteria.dateSortieProduitFrom , this.dateFormat) : environment.emptyForExport ,
            'Date sortie produit Max': this.criteria.dateSortieProduitTo ? this.datePipe.transform(this.criteria.dateSortieProduitTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Collaborateur': this.criteria.collaborateur?.prenom ? this.criteria.collaborateur?.prenom : environment.emptyForExport ,
        }];
      }
}

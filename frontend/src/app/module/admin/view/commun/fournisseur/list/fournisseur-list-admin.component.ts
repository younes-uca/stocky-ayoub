import {Component, OnInit} from '@angular/core';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-fournisseur-list-admin',
  templateUrl: './fournisseur-list-admin.component.html'
})
export class FournisseurListAdminComponent extends AbstractListController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {

    fileName = 'Fournisseur';



    constructor( private fournisseurService: FournisseurAdminService  ) {
        super(fournisseurService);
        this.pdfName = 'Fournisseur.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
            {field: 'telephone', header: 'Telephone'},
            {field: 'email', header: 'Email'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
                 'Telephone': e.telephone ,
                 'Email': e.email ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
            'Telephone': this.criteria.telephone ? this.criteria.telephone : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}

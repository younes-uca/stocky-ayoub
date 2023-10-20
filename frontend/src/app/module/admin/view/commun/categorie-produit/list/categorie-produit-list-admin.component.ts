import {Component, OnInit} from '@angular/core';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/commun/CategorieProduitAdmin.service';
import {CategorieProduitDto} from 'src/app/controller/model/commun/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/commun/CategorieProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-categorie-produit-list-admin',
  templateUrl: './categorie-produit-list-admin.component.html'
})
export class CategorieProduitListAdminComponent extends AbstractListController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService>  implements OnInit {

    fileName = 'CategorieProduit';



    constructor( private categorieProduitService: CategorieProduitAdminService  ) {
        super(categorieProduitService);
        this.pdfName = 'CategorieProduit.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}

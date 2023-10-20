import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueCriteria} from 'src/app/controller/criteria/commun/MarqueCriteria.model';
@Component({
  selector: 'app-marque-create-admin',
  templateUrl: './marque-create-admin.component.html'
})
export class MarqueCreateAdminComponent extends AbstractCreateController<MarqueDto, MarqueCriteria, MarqueAdminService>  implements OnInit {



   private _validMarqueReference = true;
   private _validMarqueLibelle = true;

    constructor( private marqueService: MarqueAdminService ) {
        super(marqueService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validMarqueReference = value;
        this.validMarqueLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateMarqueReference();
        this.validateMarqueLibelle();
    }

    public validateMarqueReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validMarqueReference = false;
        } else {
            this.validMarqueReference = true;
        }
    }
    public validateMarqueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validMarqueLibelle = false;
        } else {
            this.validMarqueLibelle = true;
        }
    }






    get validMarqueReference(): boolean {
        return this._validMarqueReference;
    }

    set validMarqueReference(value: boolean) {
         this._validMarqueReference = value;
    }
    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }

    set validMarqueLibelle(value: boolean) {
         this._validMarqueLibelle = value;
    }



}

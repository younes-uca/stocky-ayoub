import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
@Component({
  selector: 'app-fournisseur-create-admin',
  templateUrl: './fournisseur-create-admin.component.html'
})
export class FournisseurCreateAdminComponent extends AbstractCreateController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {



   private _validFournisseurReference = true;
   private _validFournisseurNom = true;
   private _validFournisseurPrenom = true;

    constructor( private fournisseurService: FournisseurAdminService ) {
        super(fournisseurService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validFournisseurReference = value;
        this.validFournisseurNom = value;
        this.validFournisseurPrenom = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFournisseurReference();
        this.validateFournisseurNom();
        this.validateFournisseurPrenom();
    }

    public validateFournisseurReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validFournisseurReference = false;
        } else {
            this.validFournisseurReference = true;
        }
    }
    public validateFournisseurNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validFournisseurNom = false;
        } else {
            this.validFournisseurNom = true;
        }
    }
    public validateFournisseurPrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
        this.errorMessages.push('Prenom non valide');
        this.validFournisseurPrenom = false;
        } else {
            this.validFournisseurPrenom = true;
        }
    }






    get validFournisseurReference(): boolean {
        return this._validFournisseurReference;
    }

    set validFournisseurReference(value: boolean) {
         this._validFournisseurReference = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }

    set validFournisseurNom(value: boolean) {
         this._validFournisseurNom = value;
    }
    get validFournisseurPrenom(): boolean {
        return this._validFournisseurPrenom;
    }

    set validFournisseurPrenom(value: boolean) {
         this._validFournisseurPrenom = value;
    }



}

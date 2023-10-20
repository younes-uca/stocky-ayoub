import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SortieProduitAdminService} from 'src/app/controller/service/admin/sortie/SortieProduitAdmin.service';
import {SortieProduitDto} from 'src/app/controller/model/sortie/SortieProduit.model';
import {SortieProduitCriteria} from 'src/app/controller/criteria/sortie/SortieProduitCriteria.model';


import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/sortie/SortieProduitItem.model';
import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/sortie/SortieProduitItemAdmin.service';

@Component({
  selector: 'app-sortie-produit-edit-admin',
  templateUrl: './sortie-produit-edit-admin.component.html'
})
export class SortieProduitEditAdminComponent extends AbstractEditController<SortieProduitDto, SortieProduitCriteria, SortieProduitAdminService>   implements OnInit {

    private _sortieProduitItemsElement = new SortieProduitItemDto();

    private _validSortieProduitReference = true;

    private _validCollaborateurNom = true;
    private _validCollaborateurPrenom = true;
    private _validSortieProduitItemsProduit = true;
    private _validSortieProduitItemsQuantite = true;
    private _validSortieProduitItemsPrix = true;



    constructor( private sortieProduitService: SortieProduitAdminService , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private sortieProduitItemService: SortieProduitItemAdminService) {
        super(sortieProduitService);
    }

    ngOnInit(): void {
        this.sortieProduitItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.collaborateur = new CollaborateurDto();
        this.collaborateurService.findAll().subscribe((data) => this.collaborateurs = data);
    }
    public prepareEdit() {
        this.item.dateSortieProduit = this.sortieProduitService.format(this.item.dateSortieProduit);
    }



    public validateSortieProduitItems(){
        this.errorMessages = new Array();
        this.validateSortieProduitItemsProduit();
        this.validateSortieProduitItemsQuantite();
        this.validateSortieProduitItemsPrix();
    }
    public setValidation(value: boolean){
        this.validSortieProduitReference = value;
        this.validSortieProduitItemsProduit = value;
        this.validSortieProduitItemsQuantite = value;
        this.validSortieProduitItemsPrix = value;
        }
   public addSortieProduitItems() {
        if( this.item.sortieProduitItems == null )
            this.item.sortieProduitItems = new Array<SortieProduitItemDto>();
       this.validateSortieProduitItems();
       if (this.errorMessages.length === 0) {
            if(this.sortieProduitItemsElement.id == null){
                this.item.sortieProduitItems.push(this.sortieProduitItemsElement);
            }else{
                const index = this.item.sortieProduitItems.findIndex(e => e.id == this.sortieProduitItemsElement.id);
                this.item.sortieProduitItems[index] = this.sortieProduitItemsElement;
            }
          this.sortieProduitItemsElement = new SortieProduitItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteSortieProduitItems(p: SortieProduitItemDto) {
        this.item.sortieProduitItems.forEach((element, index) => {
            if (element === p) { this.item.sortieProduitItems.splice(index, 1); }
        });
    }

    public editSortieProduitItems(p: SortieProduitItemDto) {
        this.sortieProduitItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSortieProduitReference();
    }
    public validateSortieProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validSortieProduitReference = false;
        } else {
            this.validSortieProduitReference = true;
        }
    }


    private validateSortieProduitItemsProduit(){
        if (this.sortieProduitItemsElement.produit == null) {
        this.errorMessages.push('Produit de la sortieProduitItem est  invalide');
            this.validSortieProduitItemsProduit = false;
        } else {
            this.validSortieProduitItemsProduit = true;
        }
    }
    private validateSortieProduitItemsQuantite(){
        if (this.sortieProduitItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la sortieProduitItem est  invalide');
            this.validSortieProduitItemsQuantite = false;
        } else {
            this.validSortieProduitItemsQuantite = true;
        }
    }
    private validateSortieProduitItemsPrix(){
        if (this.sortieProduitItemsElement.prix == null) {
        this.errorMessages.push('Prix de la sortieProduitItem est  invalide');
            this.validSortieProduitItemsPrix = false;
        } else {
            this.validSortieProduitItemsPrix = true;
        }
    }


   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get collaborateur(): CollaborateurDto {
       return this.collaborateurService.item;
   }
  set collaborateur(value: CollaborateurDto) {
        this.collaborateurService.item = value;
   }
   get collaborateurs(): Array<CollaborateurDto> {
        return this.collaborateurService.items;
   }
   set collaborateurs(value: Array<CollaborateurDto>) {
        this.collaborateurService.items = value;
   }
   get createCollaborateurDialog(): boolean {
       return this.collaborateurService.createDialog;
   }
  set createCollaborateurDialog(value: boolean) {
       this.collaborateurService.createDialog= value;
   }

    get sortieProduitItemsElement(): SortieProduitItemDto {
        if( this._sortieProduitItemsElement == null )
            this._sortieProduitItemsElement = new SortieProduitItemDto();
         return this._sortieProduitItemsElement;
    }

    set sortieProduitItemsElement(value: SortieProduitItemDto) {
        this._sortieProduitItemsElement = value;
    }

    get validSortieProduitReference(): boolean {
        return this._validSortieProduitReference;
    }
    set validSortieProduitReference(value: boolean) {
        this._validSortieProduitReference = value;
    }

    get validCollaborateurNom(): boolean {
        return this._validCollaborateurNom;
    }
    set validCollaborateurNom(value: boolean) {
        this._validCollaborateurNom = value;
    }
    get validCollaborateurPrenom(): boolean {
        return this._validCollaborateurPrenom;
    }
    set validCollaborateurPrenom(value: boolean) {
        this._validCollaborateurPrenom = value;
    }
    get validSortieProduitItemsProduit(): boolean {
        return this._validSortieProduitItemsProduit;
    }
    set validSortieProduitItemsProduit(value: boolean) {
        this._validSortieProduitItemsProduit = value;
    }
    get validSortieProduitItemsQuantite(): boolean {
        return this._validSortieProduitItemsQuantite;
    }
    set validSortieProduitItemsQuantite(value: boolean) {
        this._validSortieProduitItemsQuantite = value;
    }
    get validSortieProduitItemsPrix(): boolean {
        return this._validSortieProduitItemsPrix;
    }
    set validSortieProduitItemsPrix(value: boolean) {
        this._validSortieProduitItemsPrix = value;
    }
}

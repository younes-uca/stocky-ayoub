import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitCriteria} from 'src/app/controller/criteria/entree/EntreeProduitCriteria.model';


import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/entree/EntreeProduitItem.model';
import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitItemAdmin.service';

@Component({
  selector: 'app-entree-produit-edit-admin',
  templateUrl: './entree-produit-edit-admin.component.html'
})
export class EntreeProduitEditAdminComponent extends AbstractEditController<EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService>   implements OnInit {

    private _entreeProduitItemsElement = new EntreeProduitItemDto();

    private _validEntreeProduitReference = true;

    private _validFournisseurReference = true;
    private _validFournisseurNom = true;
    private _validFournisseurPrenom = true;
    private _validCollaborateurNom = true;
    private _validCollaborateurPrenom = true;
    private _validEntreeProduitItemsProduit = true;
    private _validEntreeProduitItemsQuantite = true;
    private _validEntreeProduitItemsPrix = true;



    constructor( private entreeProduitService: EntreeProduitAdminService , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private fournisseurService: FournisseurAdminService, private entreeProduitItemService: EntreeProduitItemAdminService) {
        super(entreeProduitService);
    }

    ngOnInit(): void {
        this.entreeProduitItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.collaborateur = new CollaborateurDto();
        this.collaborateurService.findAll().subscribe((data) => this.collaborateurs = data);
    }
    public prepareEdit() {
        this.item.dateEntreeProduit = this.entreeProduitService.format(this.item.dateEntreeProduit);
    }



    public validateEntreeProduitItems(){
        this.errorMessages = new Array();
        this.validateEntreeProduitItemsProduit();
        this.validateEntreeProduitItemsQuantite();
        this.validateEntreeProduitItemsPrix();
    }
    public setValidation(value: boolean){
        this.validEntreeProduitReference = value;
        this.validEntreeProduitItemsProduit = value;
        this.validEntreeProduitItemsQuantite = value;
        this.validEntreeProduitItemsPrix = value;
        }
   public addEntreeProduitItems() {
        if( this.item.entreeProduitItems == null )
            this.item.entreeProduitItems = new Array<EntreeProduitItemDto>();
       this.validateEntreeProduitItems();
       if (this.errorMessages.length === 0) {
            if(this.entreeProduitItemsElement.id == null){
                this.item.entreeProduitItems.push(this.entreeProduitItemsElement);
            }else{
                const index = this.item.entreeProduitItems.findIndex(e => e.id == this.entreeProduitItemsElement.id);
                this.item.entreeProduitItems[index] = this.entreeProduitItemsElement;
            }
          this.entreeProduitItemsElement = new EntreeProduitItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteEntreeProduitItems(p: EntreeProduitItemDto) {
        this.item.entreeProduitItems.forEach((element, index) => {
            if (element === p) { this.item.entreeProduitItems.splice(index, 1); }
        });
    }

    public editEntreeProduitItems(p: EntreeProduitItemDto) {
        this.entreeProduitItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEntreeProduitReference();
    }
    public validateEntreeProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validEntreeProduitReference = false;
        } else {
            this.validEntreeProduitReference = true;
        }
    }


    private validateEntreeProduitItemsProduit(){
        if (this.entreeProduitItemsElement.produit == null) {
        this.errorMessages.push('Produit de la entreeProduitItem est  invalide');
            this.validEntreeProduitItemsProduit = false;
        } else {
            this.validEntreeProduitItemsProduit = true;
        }
    }
    private validateEntreeProduitItemsQuantite(){
        if (this.entreeProduitItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la entreeProduitItem est  invalide');
            this.validEntreeProduitItemsQuantite = false;
        } else {
            this.validEntreeProduitItemsQuantite = true;
        }
    }
    private validateEntreeProduitItemsPrix(){
        if (this.entreeProduitItemsElement.prix == null) {
        this.errorMessages.push('Prix de la entreeProduitItem est  invalide');
            this.validEntreeProduitItemsPrix = false;
        } else {
            this.validEntreeProduitItemsPrix = true;
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
   get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
   }
  set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
   }
   get fournisseurs(): Array<FournisseurDto> {
        return this.fournisseurService.items;
   }
   set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
   }
   get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
   }
  set createFournisseurDialog(value: boolean) {
       this.fournisseurService.createDialog= value;
   }

    get entreeProduitItemsElement(): EntreeProduitItemDto {
        if( this._entreeProduitItemsElement == null )
            this._entreeProduitItemsElement = new EntreeProduitItemDto();
         return this._entreeProduitItemsElement;
    }

    set entreeProduitItemsElement(value: EntreeProduitItemDto) {
        this._entreeProduitItemsElement = value;
    }

    get validEntreeProduitReference(): boolean {
        return this._validEntreeProduitReference;
    }
    set validEntreeProduitReference(value: boolean) {
        this._validEntreeProduitReference = value;
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
    get validEntreeProduitItemsProduit(): boolean {
        return this._validEntreeProduitItemsProduit;
    }
    set validEntreeProduitItemsProduit(value: boolean) {
        this._validEntreeProduitItemsProduit = value;
    }
    get validEntreeProduitItemsQuantite(): boolean {
        return this._validEntreeProduitItemsQuantite;
    }
    set validEntreeProduitItemsQuantite(value: boolean) {
        this._validEntreeProduitItemsQuantite = value;
    }
    get validEntreeProduitItemsPrix(): boolean {
        return this._validEntreeProduitItemsPrix;
    }
    set validEntreeProduitItemsPrix(value: boolean) {
        this._validEntreeProduitItemsPrix = value;
    }
}

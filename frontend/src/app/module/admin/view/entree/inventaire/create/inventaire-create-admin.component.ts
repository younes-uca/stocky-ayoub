import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {InventaireAdminService} from 'src/app/controller/service/admin/entree/InventaireAdmin.service';
import {InventaireDto} from 'src/app/controller/model/entree/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/entree/InventaireCriteria.model';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {InventaireItemDto} from 'src/app/controller/model/entree/InventaireItem.model';
import {InventaireItemAdminService} from 'src/app/controller/service/admin/entree/InventaireItemAdmin.service';
@Component({
  selector: 'app-inventaire-create-admin',
  templateUrl: './inventaire-create-admin.component.html'
})
export class InventaireCreateAdminComponent extends AbstractCreateController<InventaireDto, InventaireCriteria, InventaireAdminService>  implements OnInit {

    private _inventaireItemsElement = new InventaireItemDto();


   private _validInventaireReference = true;
    private _validCollaborateurNom = true;
    private _validCollaborateurPrenom = true;
    private _validInventaireItemsProduit = true;
    private _validInventaireItemsQuantiteEstime = true;
    private _validInventaireItemsQuantiteReelle = true;

    constructor( private inventaireService: InventaireAdminService , private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private inventaireItemService: InventaireItemAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.inventaireItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.collaborateur = new CollaborateurDto();
        this.collaborateurService.findAll().subscribe((data) => this.collaborateurs = data);
    }



    validateInventaireItems(){
        this.errorMessages = new Array();
        this.validateInventaireItemsProduit();
        this.validateInventaireItemsQuantiteEstime();
        this.validateInventaireItemsQuantiteReelle();
    }


    public setValidation(value: boolean){
        this.validInventaireReference = value;
        this.validInventaireItemsProduit = value;
        this.validInventaireItemsQuantiteEstime = value;
        this.validInventaireItemsQuantiteReelle = value;
    }

    public addInventaireItems() {
        if( this.item.inventaireItems == null )
            this.item.inventaireItems = new Array<InventaireItemDto>();
       this.validateInventaireItems();
       if (this.errorMessages.length === 0) {
              this.item.inventaireItems.push({... this.inventaireItemsElement});
              this.inventaireItemsElement = new InventaireItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteinventaireItems(p: InventaireItemDto) {
        this.item.inventaireItems.forEach((element, index) => {
            if (element === p) { this.item.inventaireItems.splice(index, 1); }
        });
    }

    public editinventaireItems(p: InventaireItemDto) {
        this.inventaireItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInventaireReference();
    }

    public validateInventaireReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validInventaireReference = false;
        } else {
            this.validInventaireReference = true;
        }
    }

    public validateInventaireItemsProduit(){
        if (this.inventaireItemsElement.produit == null) {
            this.errorMessages.push('Produit de la inventaireItem est  invalide');
            this.validInventaireItemsProduit = false;
        } else {
            this.validInventaireItemsProduit = true;
        }
    }
    public validateInventaireItemsQuantiteEstime(){
        if (this.inventaireItemsElement.quantiteEstime == null) {
            this.errorMessages.push('QuantiteEstime de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteEstime = false;
        } else {
            this.validInventaireItemsQuantiteEstime = true;
        }
    }
    public validateInventaireItemsQuantiteReelle(){
        if (this.inventaireItemsElement.quantiteReelle == null) {
            this.errorMessages.push('QuantiteReelle de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteReelle = false;
        } else {
            this.validInventaireItemsQuantiteReelle = true;
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



    get validInventaireReference(): boolean {
        return this._validInventaireReference;
    }

    set validInventaireReference(value: boolean) {
         this._validInventaireReference = value;
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
    get validInventaireItemsProduit(): boolean {
        return this._validInventaireItemsProduit;
    }
    set validInventaireItemsProduit(value: boolean) {
        this._validInventaireItemsProduit = value;
    }
    get validInventaireItemsQuantiteEstime(): boolean {
        return this._validInventaireItemsQuantiteEstime;
    }
    set validInventaireItemsQuantiteEstime(value: boolean) {
        this._validInventaireItemsQuantiteEstime = value;
    }
    get validInventaireItemsQuantiteReelle(): boolean {
        return this._validInventaireItemsQuantiteReelle;
    }
    set validInventaireItemsQuantiteReelle(value: boolean) {
        this._validInventaireItemsQuantiteReelle = value;
    }

    get inventaireItemsElement(): InventaireItemDto {
        if( this._inventaireItemsElement == null )
            this._inventaireItemsElement = new InventaireItemDto();
        return this._inventaireItemsElement;
    }

    set inventaireItemsElement(value: InventaireItemDto) {
        this._inventaireItemsElement = value;
    }

}

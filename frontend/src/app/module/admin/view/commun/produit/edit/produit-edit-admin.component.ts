import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/commun/ProduitCriteria.model';


import {CategorieProduitDto} from 'src/app/controller/model/commun/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/commun/CategorieProduitAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {StockDto} from 'src/app/controller/model/commun/Stock.model';
import {StockAdminService} from 'src/app/controller/service/admin/commun/StockAdmin.service';

@Component({
  selector: 'app-produit-edit-admin',
  templateUrl: './produit-edit-admin.component.html'
})
export class ProduitEditAdminComponent extends AbstractEditController<ProduitDto, ProduitCriteria, ProduitAdminService>   implements OnInit {

    private _stocksElement = new StockDto();

    private _validProduitReference = true;
    private _validProduitPrixAchatMoyen = true;

    private _validCategorieProduitReference = true;
    private _validCategorieProduitLibelle = true;
    private _validMarqueReference = true;
    private _validMarqueLibelle = true;
    private _validStocksQuantite = true;



    constructor( private produitService: ProduitAdminService , private categorieProduitService: CategorieProduitAdminService, private marqueService: MarqueAdminService, private depotService: DepotAdminService, private stockService: StockAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.stocksElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);

        this.categorieProduit = new CategorieProduitDto();
        this.categorieProduitService.findAll().subscribe((data) => this.categorieProduits = data);
        this.marque = new MarqueDto();
        this.marqueService.findAll().subscribe((data) => this.marques = data);
    }


    public validateStocks(){
        this.errorMessages = new Array();
        this.validateStocksQuantite();
    }
    public setValidation(value: boolean){
        this.validProduitReference = value;
        this.validProduitPrixAchatMoyen = value;
        this.validStocksQuantite = value;
        }
   public addStocks() {
        if( this.item.stocks == null )
            this.item.stocks = new Array<StockDto>();
       this.validateStocks();
       if (this.errorMessages.length === 0) {
            if(this.stocksElement.id == null){
                this.item.stocks.push(this.stocksElement);
            }else{
                const index = this.item.stocks.findIndex(e => e.id == this.stocksElement.id);
                this.item.stocks[index] = this.stocksElement;
            }
          this.stocksElement = new StockDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteStocks(p: StockDto) {
        this.item.stocks.forEach((element, index) => {
            if (element === p) { this.item.stocks.splice(index, 1); }
        });
    }

    public editStocks(p: StockDto) {
        this.stocksElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitReference();
        this.validateProduitPrixAchatMoyen();
    }
    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }
    public validateProduitPrixAchatMoyen(){
        if (this.stringUtilService.isEmpty(this.item.prixAchatMoyen)) {
            this.errorMessages.push('Prix achat moyen non valide');
            this.validProduitPrixAchatMoyen = false;
        } else {
            this.validProduitPrixAchatMoyen = true;
        }
    }


    private validateStocksQuantite(){
        if (this.stocksElement.quantite == null) {
        this.errorMessages.push('Quantite de la stock est  invalide');
            this.validStocksQuantite = false;
        } else {
            this.validStocksQuantite = true;
        }
    }

   public async openCreateCategorieProduit(categorieProduit: string) {
        const isPermistted = await this.roleService.isPermitted('CategorieProduit', 'edit');
        if (isPermistted) {
             this.categorieProduit = new CategorieProduitDto();
             this.createCategorieProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateDepot(depot: string) {
        const isPermistted = await this.roleService.isPermitted('Depot', 'edit');
        if (isPermistted) {
             this.depot = new DepotDto();
             this.createDepotDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateMarque(marque: string) {
        const isPermistted = await this.roleService.isPermitted('Marque', 'edit');
        if (isPermistted) {
             this.marque = new MarqueDto();
             this.createMarqueDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get categorieProduit(): CategorieProduitDto {
       return this.categorieProduitService.item;
   }
  set categorieProduit(value: CategorieProduitDto) {
        this.categorieProduitService.item = value;
   }
   get categorieProduits(): Array<CategorieProduitDto> {
        return this.categorieProduitService.items;
   }
   set categorieProduits(value: Array<CategorieProduitDto>) {
        this.categorieProduitService.items = value;
   }
   get createCategorieProduitDialog(): boolean {
       return this.categorieProduitService.createDialog;
   }
  set createCategorieProduitDialog(value: boolean) {
       this.categorieProduitService.createDialog= value;
   }
   get depot(): DepotDto {
       return this.depotService.item;
   }
  set depot(value: DepotDto) {
        this.depotService.item = value;
   }
   get depots(): Array<DepotDto> {
        return this.depotService.items;
   }
   set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
   }
   get createDepotDialog(): boolean {
       return this.depotService.createDialog;
   }
  set createDepotDialog(value: boolean) {
       this.depotService.createDialog= value;
   }
   get marque(): MarqueDto {
       return this.marqueService.item;
   }
  set marque(value: MarqueDto) {
        this.marqueService.item = value;
   }
   get marques(): Array<MarqueDto> {
        return this.marqueService.items;
   }
   set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
   }
   get createMarqueDialog(): boolean {
       return this.marqueService.createDialog;
   }
  set createMarqueDialog(value: boolean) {
       this.marqueService.createDialog= value;
   }

    get stocksElement(): StockDto {
        if( this._stocksElement == null )
            this._stocksElement = new StockDto();
         return this._stocksElement;
    }

    set stocksElement(value: StockDto) {
        this._stocksElement = value;
    }

    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitPrixAchatMoyen(): boolean {
        return this._validProduitPrixAchatMoyen;
    }
    set validProduitPrixAchatMoyen(value: boolean) {
        this._validProduitPrixAchatMoyen = value;
    }

    get validCategorieProduitReference(): boolean {
        return this._validCategorieProduitReference;
    }
    set validCategorieProduitReference(value: boolean) {
        this._validCategorieProduitReference = value;
    }
    get validCategorieProduitLibelle(): boolean {
        return this._validCategorieProduitLibelle;
    }
    set validCategorieProduitLibelle(value: boolean) {
        this._validCategorieProduitLibelle = value;
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
    get validStocksQuantite(): boolean {
        return this._validStocksQuantite;
    }
    set validStocksQuantite(value: boolean) {
        this._validStocksQuantite = value;
    }
}

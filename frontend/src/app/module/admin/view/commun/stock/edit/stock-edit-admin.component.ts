import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StockAdminService} from 'src/app/controller/service/admin/commun/StockAdmin.service';
import {StockDto} from 'src/app/controller/model/commun/Stock.model';
import {StockCriteria} from 'src/app/controller/criteria/commun/StockCriteria.model';


import {ProduitDto} from 'src/app/controller/model/commun/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/commun/ProduitAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';

@Component({
  selector: 'app-stock-edit-admin',
  templateUrl: './stock-edit-admin.component.html'
})
export class StockEditAdminComponent extends AbstractEditController<StockDto, StockCriteria, StockAdminService>   implements OnInit {


    private _validStockQuantite = true;

    private _validProduitReference = true;
    private _validProduitPrixAchatMoyen = true;
    private _validDepotLibelle = true;



    constructor( private stockService: StockAdminService , private produitService: ProduitAdminService, private depotService: DepotAdminService) {
        super(stockService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }


    public setValidation(value: boolean){
        this.validStockQuantite = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStockQuantite();
    }
    public validateStockQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validStockQuantite = false;
        } else {
            this.validStockQuantite = true;
        }
    }



   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
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


    get validStockQuantite(): boolean {
        return this._validStockQuantite;
    }
    set validStockQuantite(value: boolean) {
        this._validStockQuantite = value;
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
    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
}

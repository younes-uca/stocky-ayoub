import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-inventaire-view-admin',
  templateUrl: './inventaire-view-admin.component.html'
})
export class InventaireViewAdminComponent extends AbstractViewController<InventaireDto, InventaireCriteria, InventaireAdminService> implements OnInit {

    inventaireItems = new InventaireItemDto();
    inventaireItemss: Array<InventaireItemDto> = [];

    constructor(private inventaireService: InventaireAdminService, private collaborateurService: CollaborateurAdminService, private produitService: ProduitAdminService, private inventaireItemService: InventaireItemAdminService){
        super(inventaireService);
    }

    ngOnInit(): void {
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


}

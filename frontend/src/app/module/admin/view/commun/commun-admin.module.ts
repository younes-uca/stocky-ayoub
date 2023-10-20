import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';

import { CategorieProduitCreateAdminComponent } from './categorie-produit/create/categorie-produit-create-admin.component';
import { CategorieProduitEditAdminComponent } from './categorie-produit/edit/categorie-produit-edit-admin.component';
import { CategorieProduitViewAdminComponent } from './categorie-produit/view/categorie-produit-view-admin.component';
import { CategorieProduitListAdminComponent } from './categorie-produit/list/categorie-produit-list-admin.component';
import { MarqueCreateAdminComponent } from './marque/create/marque-create-admin.component';
import { MarqueEditAdminComponent } from './marque/edit/marque-edit-admin.component';
import { MarqueViewAdminComponent } from './marque/view/marque-view-admin.component';
import { MarqueListAdminComponent } from './marque/list/marque-list-admin.component';
import { CollaborateurCreateAdminComponent } from './collaborateur/create/collaborateur-create-admin.component';
import { CollaborateurEditAdminComponent } from './collaborateur/edit/collaborateur-edit-admin.component';
import { CollaborateurViewAdminComponent } from './collaborateur/view/collaborateur-view-admin.component';
import { CollaborateurListAdminComponent } from './collaborateur/list/collaborateur-list-admin.component';
import { FournisseurCreateAdminComponent } from './fournisseur/create/fournisseur-create-admin.component';
import { FournisseurEditAdminComponent } from './fournisseur/edit/fournisseur-edit-admin.component';
import { FournisseurViewAdminComponent } from './fournisseur/view/fournisseur-view-admin.component';
import { FournisseurListAdminComponent } from './fournisseur/list/fournisseur-list-admin.component';
import { DepotCreateAdminComponent } from './depot/create/depot-create-admin.component';
import { DepotEditAdminComponent } from './depot/edit/depot-edit-admin.component';
import { DepotViewAdminComponent } from './depot/view/depot-view-admin.component';
import { DepotListAdminComponent } from './depot/list/depot-list-admin.component';
import { ProduitCreateAdminComponent } from './produit/create/produit-create-admin.component';
import { ProduitEditAdminComponent } from './produit/edit/produit-edit-admin.component';
import { ProduitViewAdminComponent } from './produit/view/produit-view-admin.component';
import { ProduitListAdminComponent } from './produit/list/produit-list-admin.component';
import { StockCreateAdminComponent } from './stock/create/stock-create-admin.component';
import { StockEditAdminComponent } from './stock/edit/stock-edit-admin.component';
import { StockViewAdminComponent } from './stock/view/stock-view-admin.component';
import { StockListAdminComponent } from './stock/list/stock-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    CategorieProduitCreateAdminComponent,
    CategorieProduitListAdminComponent,
    CategorieProduitViewAdminComponent,
    CategorieProduitEditAdminComponent,
    MarqueCreateAdminComponent,
    MarqueListAdminComponent,
    MarqueViewAdminComponent,
    MarqueEditAdminComponent,
    CollaborateurCreateAdminComponent,
    CollaborateurListAdminComponent,
    CollaborateurViewAdminComponent,
    CollaborateurEditAdminComponent,
    FournisseurCreateAdminComponent,
    FournisseurListAdminComponent,
    FournisseurViewAdminComponent,
    FournisseurEditAdminComponent,
    DepotCreateAdminComponent,
    DepotListAdminComponent,
    DepotViewAdminComponent,
    DepotEditAdminComponent,
    ProduitCreateAdminComponent,
    ProduitListAdminComponent,
    ProduitViewAdminComponent,
    ProduitEditAdminComponent,
    StockCreateAdminComponent,
    StockListAdminComponent,
    StockViewAdminComponent,
    StockEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,

  ],
  exports: [
  CategorieProduitCreateAdminComponent,
  CategorieProduitListAdminComponent,
  CategorieProduitViewAdminComponent,
  CategorieProduitEditAdminComponent,
  MarqueCreateAdminComponent,
  MarqueListAdminComponent,
  MarqueViewAdminComponent,
  MarqueEditAdminComponent,
  CollaborateurCreateAdminComponent,
  CollaborateurListAdminComponent,
  CollaborateurViewAdminComponent,
  CollaborateurEditAdminComponent,
  FournisseurCreateAdminComponent,
  FournisseurListAdminComponent,
  FournisseurViewAdminComponent,
  FournisseurEditAdminComponent,
  DepotCreateAdminComponent,
  DepotListAdminComponent,
  DepotViewAdminComponent,
  DepotEditAdminComponent,
  ProduitCreateAdminComponent,
  ProduitListAdminComponent,
  ProduitViewAdminComponent,
  ProduitEditAdminComponent,
  StockCreateAdminComponent,
  StockListAdminComponent,
  StockViewAdminComponent,
  StockEditAdminComponent,
  ],
  entryComponents: [],
})
export class CommunAdminModule { }

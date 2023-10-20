
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { EntreeProduitListAdminComponent } from './entree-produit/list/entree-produit-list-admin.component';
import { InventaireListAdminComponent } from './inventaire/list/inventaire-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'entree-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: EntreeProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'inventaire',
                            children: [
                                {
                                    path: 'list',
                                    component: InventaireListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class EntreeAdminRoutingModule { }

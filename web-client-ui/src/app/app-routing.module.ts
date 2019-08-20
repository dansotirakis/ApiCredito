import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ClienteListComponent } from './cliente-list/cliente-list.component';
import { CreateClienteComponent } from './cliente-add/cliente-add.component';
import { ClienteDetailsComponent } from './cliente-detail/cliente-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'cliente', pathMatch: 'full' },
  { path: 'clientes', component: ClienteListComponent },
  { path: 'add', component: CreateClienteComponent },
  { path: 'details/:id', component: ClienteDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

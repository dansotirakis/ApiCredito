import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteComponent } from './cliente/cliente.component';
import { PerfilComponent } from './perfil/perfil.component';
import { HttpClientModule } from '@angular/common/http';
import { ClienteService } from './services/cliente/cliente.service';
import { PerfilService } from './services/perfil/perfil.service';
import { PropostaService } from './services/proposta/proposta.service';
import { ClienteListComponent } from './cliente-list/cliente-list.component';
import { PropostaListComponent } from './proposta-list/proposta-list.component';
import { PropostaClientListComponent } from './proposta-client-list/proposta-client-list.component';
import { PerfilListComponent } from './perfil-list/perfil-list.component';
import { PerfilClienteListComponent } from './perfil-cliente-list/perfil-cliente-list.component';
import { PerfilEditComponent } from './perfil-edit/perfil-edit.component';
import { ClienteEditComponent } from './cliente-edit/cliente-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    PerfilComponent,
    ClienteListComponent,
    PropostaListComponent,
    PropostaClientListComponent,
    PerfilListComponent,
    PerfilClienteListComponent,
    PerfilEditComponent,
    ClienteEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ClienteService,PerfilService,PropostaService],
  bootstrap: [AppComponent]
})
export class AppModule { }

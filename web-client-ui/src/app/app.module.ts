import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { ClienteFindComponent } from './cliente-find/cliente-find.component';
import { PerfilFindComponent } from './perfil-find/perfil-find.component';
import { PerfilAddComponent } from './perfil-add/perfil-add.component';
import { PropostaFindComponent } from './proposta-find/proposta-find.component';
import { PropostaDetailComponent } from './proposta-detail/proposta-detail.component';
import { PerfilDetailComponent } from './perfil-detail/perfil-detail.component';
import { ClienteDetailsComponent } from './cliente-detail/cliente-detail.component';
import { CreateClienteComponent } from './cliente-add/cliente-add.component';


@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    CreateClienteComponent,
    ClienteDetailsComponent,
    PropostaListComponent,
    PropostaClientListComponent,
    PerfilListComponent,
    PerfilClienteListComponent,
    PerfilEditComponent,
    ClienteEditComponent,
    ClienteFindComponent,
    PerfilFindComponent,
    PerfilAddComponent,
    PropostaFindComponent,
    PropostaDetailComponent,
    PerfilDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClienteService,PerfilService,PropostaService],
  bootstrap: [AppComponent]
})
export class AppModule { }

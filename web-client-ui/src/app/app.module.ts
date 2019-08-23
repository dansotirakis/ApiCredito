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
import { ClienteDetailsComponent } from './cliente-detail/cliente-detail.component';
import { CreateClienteComponent } from './cliente-add/cliente-add.component';
import { CpfdiretiveDirective } from './cpfdiretive.directive';


@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    CreateClienteComponent,
    ClienteDetailsComponent,
    CpfdiretiveDirective,

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

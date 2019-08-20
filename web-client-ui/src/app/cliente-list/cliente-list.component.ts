import { ClienteDetailsComponent } from '../cliente-detail/cliente-detail.component';
import { Observable } from "rxjs";
import { ClienteService } from '../services/cliente/cliente.service';
import { cliente } from "../cliente";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-cliente-list",
  templateUrl: "./cliente-list.component.html",
  styleUrls: ["./cliente-list.component.css"]
})
export class ClienteListComponent implements OnInit {
  clientes: Observable<cliente[]>;

  constructor(private clienteService: ClienteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.clientes = this.clienteService.getClientesList();
  }

  deleteCliente(id: number) {
    this.clienteService.deleteCliente(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  clienteDetails(id: number){
    this.router.navigate(['details', id]);
  }
}
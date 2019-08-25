import { Observable } from "rxjs";
import { PropostaService } from '../services/proposta/proposta.service';
import { proposta } from "../proposta";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-cliente-list",
  templateUrl: "./cliente-list.component.html",
  styleUrls: ["./cliente-list.component.css"]
})
export class ClienteListComponent implements OnInit {
  
  propostas: Observable<proposta[]>;

  constructor(private router: Router,
              private propostaService: PropostaService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.propostas = this.propostaService.getPropostasList();
  }

  deleteCliente(id: number) {
    console.log(id);
    this.reloadData();
  }

  clienteDetails(id: number){
    this.router.navigate(['details', id]);
  }
}
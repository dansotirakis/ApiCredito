import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../services/cliente/cliente.service';

@Component({
  selector: 'client-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  clienteConta = '';
  clienteSenha = '';

  constructor(private contaService: ClienteService) { }

  ngOnInit() {
    this.contaService.consultarConta();

  }

  inserirNome(event: any) {
    this.clienteConta = event.target.value;
  }
  inserirSenha(event: any) {
    this.clienteSenha = event.target.value;
  }


  login(conta: string, senha: string) {
    this.clienteConta = conta;
    this.clienteSenha = senha;
    console.log(conta);
    console.log(senha);
  }

}

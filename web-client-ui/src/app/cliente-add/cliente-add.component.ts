import { ClienteService } from '../services/cliente/cliente.service';
import { cliente } from '../cliente';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-add',
  templateUrl: './cliente-add.component.html',
  styleUrls: ['./cliente-add.component.css']
})
export class CreateClienteComponent implements OnInit {

  cliente: cliente = new cliente();
  submitted = false;

  constructor(private clienteService: ClienteService,
    private router: Router) { }

  ngOnInit() {
  }

  newCliente(): void {
    this.submitted = false;
    this.cliente = new cliente();
  }

  save() {
    this.clienteService.createCliente(this.cliente)
      .subscribe(data => console.log(data), error => console.log(error));
    this.cliente = new cliente();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/clientes']);
  }
}
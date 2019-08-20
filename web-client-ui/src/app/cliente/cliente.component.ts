import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'WEB-CLIENTE-CREDIT',
  templateUrl: './cad-cliente.component.html',
  styleUrls: ['./cad-cliente.component.css']
})

export class ClienteComponent {
  items: any;
  checkoutForm: any;

  constructor(
    private clienteService: ClienteService,
    private formBuilde: FormBuilder,

  ) {
    //this.items = this.clienteService.getItems();

    this.checkoutForm = this.formBuilde.group({
      nome: '',
      idade: '',
      sexo: '',
      estadocivil: '',
      estado: '',
      dependentes: '',
      renda: ''

    }
  }
  onSubmit(customerData) {
    // Process checkout data here
    console.warn('Your order has been submitted', customerData);

    //this.items = this.clienteService.clearCart();
    this.checkoutForm.reset();
  }
  public getItems() {
    return this.items;
  }
}
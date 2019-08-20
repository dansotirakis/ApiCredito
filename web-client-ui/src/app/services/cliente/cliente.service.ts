import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class ClienteService {
  conta = '';
  constructor(private http: HttpClient) { }

  consultarConta() {
    this.http.get('http://localhost:8180/conta/1').subscribe(response => { console.log(response) })
  }

  consultarSenha() {
    this.http.get(`http://localhost:8180/conta/pass/` + this.conta).subscribe(response => { console.log(response.valueOf) })
  }

}

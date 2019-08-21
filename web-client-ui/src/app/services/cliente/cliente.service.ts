import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { cliente } from 'src/app/cliente';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private baseUrl = 'http://localhost:8180/cliente';

  constructor(private http: HttpClient) { }

   
  updateCliente(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  
  deleteCliente(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  
  getClientesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/list`);
  }

  createCliente(Cliente: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, Cliente);
  }

  getCliente(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';

@Injectable({
  providedIn: 'root'
})
export class PropostaService {
  private baseUrl = 'http://localhost:8180/proposta';
  
  constructor(private http: HttpClient) { }   

  getPropostasList(): Observable <any> {
    return this.http.get(`${this.baseUrl}/list`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';


@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  
  private baseUrl = 'http://localhost:8180/perfil';

  constructor(private http: HttpClient) { }

    updatePerfil(id: number, value: any): Observable < Object > {
      return this.http.put(`${this.baseUrl}/${id}`, value);
    }

    deletePerfil(id: number): Observable < any > {
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
    }

    getPerfilsList(): Observable < any > {
      return this.http.get(`${this.baseUrl}/list`);
    }

    createPerfil(Perfil: Object): Observable < Object > {
      return this.http.post(`${this.baseUrl}/add`, Perfil);
    }

    getPerfil(id: number): Observable < any > {
      return this.http.get(`${this.baseUrl}/${id}`);
    }
  
}

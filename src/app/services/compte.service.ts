import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private http: HttpClient) { }

  public getAllCompte():Observable<Array<Compte>>{
    return this.http.get<Array<Compte>>(`http://localhost:8080/api/comptes`);
  }

  public deleteCompte(compte: Compte){
    return this.http.delete<Array<Compte>>(`http://localhost:8080/api/comptes/${compte.id}`);
  }

  public getCompteById(compteId:number):Observable<Compte>{
    return this.http.get<Compte>(`http://localhost:8080/api/comptes/${compteId}`);
  }

  public updateCompte(compte:Compte):Observable<Compte>{
    return this.http.put<Compte>(`http://localhost:8080/api/comptes/${compte.id}`, compte);
  }
  public saveCompte(compte:Compte):Observable<Compte>{
    return this.http.post<Compte>(`http://localhost:8080/api/comptes`, compte);
  }
}

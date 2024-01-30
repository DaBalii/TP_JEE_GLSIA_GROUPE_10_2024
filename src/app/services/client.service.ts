import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  public getAllClient():Observable<Array<Client>>{
    return this.http.get<Array<Client>>('http://localhost:8080/api/clients');

  }

  public saveClient(client:Client):Observable<Client>{
    return this.http.post<Client>(`http://localhost:8080/api/clients`, client);
  }

  public deleteClient(client:Client){
    return this.http.delete<Array<Client>>(`http://localhost:8080/api/clients/${client.id}`);

  }

  public getClientById(clientId:number):Observable<Client>{
    return this.http.get<Client>(`http://localhost:8080/api/clients/${clientId}`);
  }

  public editerClient(client:Client):Observable<Client>{
    return this.http.put<Client>(`http://localhost:8080/api/clients/${client.id}`, client);
  }
}

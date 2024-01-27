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
}

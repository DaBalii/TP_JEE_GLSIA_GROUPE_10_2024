import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest, RegisterRequest } from '../models/log.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(loginRequest: LoginRequest): Observable<any>{
    return this.http.post(`http://localhost:8080/api/login`,loginRequest);

  }

  register(registerRequest: RegisterRequest): Observable<any>{
    return this.http.post(`http://localhost:8080/api/register`, registerRequest);
  }


}

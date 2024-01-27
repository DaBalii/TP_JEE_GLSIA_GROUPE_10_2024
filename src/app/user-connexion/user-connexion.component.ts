import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { LoginRequest } from '../models/log.model';

@Component({
  selector: 'app-user-connexion',
  templateUrl: './user-connexion.component.html',
  styleUrls: ['./user-connexion.component.css']
})
export class UserConnexionComponent {

  constructor(private router: Router,
    private authservice: AuthService){}

  login(loginRequest: LoginRequest):void{
    this.authservice.login(loginRequest).subscribe(
      (Response) => {
        console.log('login successful', Response);
      },
      (error) => {
        console.error('Login failed', error);

      }
    )
  }

  register(){
    this.router.navigate(['register']);
  }

  liste(){
    this.router.navigate(['liste']);
  }

}

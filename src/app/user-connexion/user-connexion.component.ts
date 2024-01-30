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
  loginRequest: LoginRequest = { username: '', password: '' };
  userNameErrors: string[] = [];
  passwordErrors: string[] = [];

  constructor(private router: Router, private authService: AuthService) {}

  login(): void {
    // Clear previous errors
    this.userNameErrors = [];
    this.passwordErrors = [];

    // Validate form
    if (!this.loginRequest.username) {
      this.userNameErrors.push('Username is required');
    }

    if (!this.loginRequest.password) {
      this.passwordErrors.push('Password is required');
    }

    // If no validation errors, proceed with login
    if (this.userNameErrors.length === 0 && this.passwordErrors.length === 0) {
      this.authService.login(this.loginRequest).subscribe(
        (response) => {
          console.log('Login successful', response);
          // Redirect or perform other actions upon successful login
        },
        (error) => {
          console.error('Login failed', error);
          // Handle specific error cases if needed
        }
      );
    }
  }

  register() {
    this.router.navigate(['register']);
  }

  liste() {
    this.router.navigate(['liste']);
  }
}

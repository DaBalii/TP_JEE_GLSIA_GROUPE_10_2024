import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { RegisterRequest } from '../models/log.model';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {
  registerRequest: RegisterRequest = { username: '', password: '', entity_no: '' };
  userNameErrors: string[] = [];
  passwordErrors: string[] = [];

  constructor(private router: Router, private authService: AuthService) {}

  register(): void {
    // Clear previous errors
    this.userNameErrors = [];
    this.passwordErrors = [];

    // Validate form
    if (!this.registerRequest.username) {
      this.userNameErrors.push('Username is required');
    }

    if (!this.registerRequest.password) {
      this.passwordErrors.push('Password is required');
    }


    if (
      this.userNameErrors.length === 0 &&
      this.passwordErrors.length === 0
    ) {
      this.authService.register(this.registerRequest).subscribe(
        (response) => {
          console.log('Registration successful', response);
          // Redirect or perform other actions upon successful registration
        },
        (error) => {
          console.error('Registration failed', error);
          // Handle specific error cases if needed
        }
      );
    }
  }

  login() {
    this.router.navigate(['login']);
  }
}

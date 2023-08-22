import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string | undefined;
  password: string | undefined;

  constructor(private router: Router) {}

  login() {
    // Implement your login logic here
    // You can use services to communicate with the server
    // Example: authService.login(this.username, this.password)
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}

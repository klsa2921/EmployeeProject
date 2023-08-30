import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NgForm} from "@angular/forms";
import {UserService} from "../_services/user.service";
import {resolve} from "@angular/compiler-cli";
import {UserAuthService} from "../_services/user-auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  // username: string = '';
  // password: string = '';
  //
  // constructor(private http: HttpClient) {}
  //
  // login() {
  //   const credentials = {
  //     username: this.username,
  //     password: this.password
  //   };
  //
  //   this.http.post('your-api-endpoint', credentials).subscribe(
  //     (response: any) => {
  //       console.log('Login successful!', response);
  //     },
  //     (error) => {
  //       console.error('Login error', error);
  //     }
  //   );
  // }
  email:string='';
  password:string='';
  constructor(private userService:UserService,
              private userAuthService:UserAuthService,
              private router:Router) {
  }
  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response:any)=>{
        console.log(response);
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);

        const role=response.user.role[0].role;
        if (role==='ADMIN'){
          this.router.navigate(['/admin']);
        }else{
          this.router.navigate(['/user']);
        }
      },error => {
        console.log(error);
      }
    );
  }
}

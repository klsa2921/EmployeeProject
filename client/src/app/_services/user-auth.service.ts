import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {
  constructor() {
  }

  public setRoles(roles: []) {
    localStorage.setItem("roles", JSON.stringify(roles));
  }

  // public getRoles(): []{
  //   return JSON.parse(localStorage.getItem('roles'));
  // }

  public setToken(jwtToken: string) {
    localStorage.setItem("jwtToken", jwtToken);
  }

  // public getToken(): string {
  //   console.log(localStorage.getItem('jwtToken'));
  //   return localStorage.getItem('jwtToken');
  // }

  public clear() {
    localStorage.clear();
  }

  public isLoggedIn() {
    return "hello";


  }
}

import { Component } from '@angular/core';
import {UserAuthService} from "../_services/user-auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private userAuthService:UserAuthService) {
  }
  ngOnIit():void{

  }
  public isLoggedIn(){
    return this.userAuthService.isLoggedIn();
  }
}

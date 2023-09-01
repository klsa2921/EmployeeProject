import { Component } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  user:any={firstName:'Mukesh',lastName:'Klsa',email:'klsa2921@gmail.com',role:'ADMIN'}
}

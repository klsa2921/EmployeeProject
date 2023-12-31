import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {LoginComponent} from "./login/login.component";
import {EmployeeComponent} from "./employee/employee.component";
import {RegisterComponent} from "./register/register.component";
import {EmployeeManagementComponent} from "./employee-management/employee-management.component";

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'user',component:UserComponent},
  {path:'employee',component:EmployeeComponent},
  {path:'registration',component:RegisterComponent},
  {path:'employeeManagement',component:EmployeeManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

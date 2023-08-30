import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_API="http://localhost:2921";
  requestHeader=new HttpHeaders(
    {"No-Auth":"True"}
  );
  constructor(private httpClient:HttpClient) { }
  public login(loginData: any){
    return this.httpClient.post(this.PATH_API + "/authenticate",loginData,{headers:this.requestHeader});
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  url:string="http://localhost:8080/";

  constructor(private http:HttpClient) { }

  postUser(obj:any){
  return this.http.post(`${this.url}addingUser`,obj);
  }

  login(obj:any){
    return this.http.post(`${this.url}login`,obj);
  }
}

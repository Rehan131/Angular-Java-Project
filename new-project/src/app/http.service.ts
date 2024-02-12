import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url:string='http://localhost:8080';

  constructor(private http:HttpClient) { }

  getAllMobiles(){
    return  this.http.get(`${this.url}/getAllMobiles`);
  }

  getByMobSpeed(){
    return this.http.get(`${this.url}/getBySpeed`)
  }

  addData(obj:any){
    return this.http.post(`${this.url}/addMobile`,obj);
  }

  updateData(obj:any){
    return this.http.put(`${this.url}/updateMobile`,obj);
  }

  deleteData(id:any){
    return this.http.delete(`${this.url}/deleteMobile/${id}`);
  }

  getOneData(id:any){
    return this.http.get(`${this.url}/getOneMobile/${id}`);
  }
}

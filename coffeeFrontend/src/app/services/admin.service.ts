import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../Entities/Product';
const AUTH_API = 'http://localhost:8080/admin/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})


export class adminServiceService {

  constructor(private http : HttpClient) { }
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API,{
      username,
      password
    }, httpOptions);
  }

  addProduct(product :Product): Observable<any> {
    return this.http.post(AUTH_API + '/product/add', {
     product
    }, httpOptions);
  }
}
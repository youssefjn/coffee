import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const AUTH_API="http://localhost:8080/home"
@Injectable({
  providedIn: 'root'
})

export class ProductsService {
  constructor(private http: HttpClient) {
  }
  getAllProducts(): Observable<any> {
    return this.http.get(AUTH_API + '/all', httpOptions);
  }
}
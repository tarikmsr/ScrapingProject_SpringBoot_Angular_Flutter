import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Utilisateur } from './utilisateur';
import { Token } from '@angular/compiler';
import 'ngx-webstorage';
import { Router, Routes } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthentifictionService {
    constructor(
      private http:HttpClient,
      private route:Router
    ) { }
    isLogged(){
      return !!localStorage.getItem('token');
    }
    
    login(utilisateur: Utilisateur):Observable<Object>{
      console.log(utilisateur);
      return this.http.post(`http://localhost:8080/login`,utilisateur);
    }
    logout(){
      localStorage.removeItem('token');
      this.route.navigate(['/login'])
    }
}

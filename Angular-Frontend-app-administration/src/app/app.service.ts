import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from './utilisateur';
import {Data} from './data/data';
@Injectable({
  providedIn: 'root'
})


export class AppService {

  constructor(
    private http:HttpClient,
  ) { }
  getAll(){
    return this.http.get(`http://localhost:8080/findAllUtilisateurs`);
  }
  update(id: string,utilisateur: any){
    return this.http.put(`http://localhost:8080/updateUtilisateur/${id}`,utilisateur);
  }
  create(Utilisateur: any){
    return this.http.post(`http://localhost:8080/addUtilisateur`,Utilisateur);
  }
  delete(id: string){
    return this.http.delete(`http://localhost:8080/deleteUtilisateur/${id}`);
  }

  saveData(Data:any){
    return this.http.put(`http://localhost:8080/saveData`,Data);
  }
  getData(){
    return this.http.get(`http://localhost:8080/findAllDataSet`);
  }

  Datadelete(id: string){
    return this.http.delete(`http://localhost:8080/deleteDataLine/${id}`);
  }
  
  Dataedit(id: string,Data: any){
 
    return this.http.put(`http://localhost:8080/updateData/${id}`,Data);
    
  }

}

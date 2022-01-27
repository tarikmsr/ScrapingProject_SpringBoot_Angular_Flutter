import { Component , OnInit } from '@angular/core';
import { AppService } from './app.service';
import {AuthentifictionService} from './authentifiction.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit{
  title = 'scrapAdmin';
  
  utilisateurs:any[]=[];
  utilisateur= {
    id: null,
    nom: '',
    prenom:'',
  };

  constructor(
    private appService:AppService,
    public authentifictionService:AuthentifictionService
  ){}
  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.appService.getAll().subscribe((data: any) => this.utilisateurs = data);
  }
  save(){
    if(this.utilisateur.id!){
      this.appService.update(this.utilisateur.id,this.utilisateur).subscribe(() =>this.getAll());
    }else{
      this.appService.create(this.utilisateur).subscribe(() =>this.getAll());
    }
    this.utilisateur={
      id: null,
      nom: '',
      prenom:'',
    }
  }
  edit(u: any){
    this.utilisateur={
      ...u
    };
  }
  delete(utilisateur: any){
    this.appService.delete(utilisateur.id).subscribe(()=> this.getAll());
  }
  logout(){
    this.authentifictionService.logout();
  }
  islogged(){
    this.authentifictionService.isLogged();
  }

  DownloadData(){
  }

}

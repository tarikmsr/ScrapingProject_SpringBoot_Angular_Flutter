import { Component, OnInit } from '@angular/core';
import { AuthentifictionService } from '../authentifiction.service';
import { Utilisateur } from '../utilisateur';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
utilisateur:Utilisateur=new Utilisateur();

  constructor(
    private Service:AuthentifictionService,
    private route: Router
  ){}

  ngOnInit(): void {
  }
  login(){
    this.Service.login(this.utilisateur).subscribe(
      (data:any)=>{
        console.log(data);
        if(data.id!=null){
        const token=data.id;
        localStorage.setItem('token',token);
        alert("login sucessfully");
        this.route.navigate(['/'])
        }else{
        alert("Sorry Please enter correct information");
        }
     // 
    
    },//error=>alert("Sorry Please enter correct information")
    );
  }

}

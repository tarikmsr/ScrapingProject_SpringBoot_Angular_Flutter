import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import  {GestionUtilisateursComponent} from './gestion-utilisateurs/gestion-utilisateurs.component'
import { RouterModule, Routes } from '@angular/router';
import  {LoginComponent} from './login/login.component'
import  {AppComponent} from './app.component'
import {AuthGuard} from './login/auth.guard'
import {LogoutGuard} from './login/logout.guard'
import {DataComponent} from './data/data.component'

const routes: Routes = [
{path:"gestion_utilisateurs",component: GestionUtilisateursComponent,canActivate:[AuthGuard]},
{path:"login",component:LoginComponent,canActivate:[LogoutGuard]},
{path:"app",component:AppComponent},
{path:"data",component:DataComponent,canActivate:[AuthGuard]}// if you want to test it remove ,canActivate:[AuthGuard] from this line
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers:[]
})
export class AppRoutingModule { }

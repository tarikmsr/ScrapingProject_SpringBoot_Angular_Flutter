import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GestionUtilisateursComponent } from './gestion-utilisateurs/gestion-utilisateurs.component';
import { LoginComponent } from './login/login.component';
import {AuthGuard} from './login/auth.guard'
import {LogoutGuard} from './login/logout.guard';
import { ComponentNameComponent } from './component-name/component-name.component';
import { DataComponent } from './data/data.component'


@NgModule({
  declarations: [
    AppComponent,
    GestionUtilisateursComponent,
    LoginComponent,
    ComponentNameComponent,
    DataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [AuthGuard,LogoutGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

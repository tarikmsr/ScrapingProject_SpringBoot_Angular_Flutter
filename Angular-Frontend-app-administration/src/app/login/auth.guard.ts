import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Routes, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Injectable()
export class AuthGuard implements CanActivate{
    
    canActivate(route: ActivatedRouteSnapshot, 
        state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        const token=localStorage.getItem('token');
        return (!!token)
    }
    

}
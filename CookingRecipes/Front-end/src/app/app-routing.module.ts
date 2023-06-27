import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterPageComponent} from "./components/register-page/register-page.component";
import {HomePageComponent} from "./components/home-page/home-page.component";

const routes: Routes = [
  { path: '', redirectTo: '/homePage', pathMatch: 'full' },
  {path:'homePage', component:HomePageComponent},
  {path: 'register', component: RegisterPageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

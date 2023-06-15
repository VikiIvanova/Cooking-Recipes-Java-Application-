import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterPageComponent} from "./components/register-page/register-page.component";
import {HomePageComponent} from "./components/home-page/home-page.component";

const routes: Routes = [
  { path: 'register', component: RegisterPageComponent },
  { path: '', redirectTo: '/allRecipe', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export { routes };

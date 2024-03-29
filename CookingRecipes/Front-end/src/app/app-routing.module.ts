import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterPageComponent} from "./components/register-page/register-page.component";
import {HomePageComponent} from "./components/home-page/home-page.component";
import {LoginComponent} from "./components/login/login.component";
import {RecipeDetailsComponent} from "./components/recipes/recipe-details/recipe-details.component";
import {RecipeFavoriteComponent} from "./components/recipes/recipe-favorite/recipe-favorite.component";
import {RecipeAddComponent} from "./components/recipes/recipe-add/recipe-add.component";

const routes: Routes = [
  { path: '', redirectTo: '/homePage', pathMatch: 'full' },
  {path:'homePage', component:HomePageComponent},
  {path: 'register', component: RegisterPageComponent },
  {path: 'login', component: LoginComponent},
  {path: 'details/:id', component: RecipeDetailsComponent},
  {path: 'favoriteRecipes', component:RecipeFavoriteComponent},
  {path: 'addRecipe', component:RecipeAddComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

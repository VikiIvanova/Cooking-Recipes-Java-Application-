import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecipeModel} from "../interfaces/recipe.model";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor(private http: HttpClient) { }

  getAllRecipes(): Observable<RecipeModel[]> {
    return this.http.get<RecipeModel[]>('/api/recipes/allrecipes');
  }

  // createRecipe(recipeDto: CreateRecipeDto): Observable<number> {
  //   return this.http.post<number>('/api/recipes/createrecipe', recipeDto);
  // }
  //
  // updateRecipe(id: number, recipeDto: CreateRecipeDto): Observable<void> {
  //   return this.http.put<void>(`/api/recipes/${id}`, recipeDto);
  // }

  // deleteRecipe(id: number): Observable<void> {
  //   return this.http.delete<void>(`/api/recipes/${id}`);
  // }
  //
  // getRecipeById(id: number): Observable<RecipeModel> {
  //   return this.http.get<RecipeModel>(`/api/recipes/${id}`);
  // }

  searchRecipes(name?: string, category?: string, productName?: string): Observable<RecipeModel[]> {
    const params: any = {};
    if (name) {
      params.name = name;
    }
    if (category) {
      params.category = category;
    }
    if (productName) {
      params.productName = productName;
    }
    return this.http.get<RecipeModel[]>('/api/recipes/search', { params });
  }

}

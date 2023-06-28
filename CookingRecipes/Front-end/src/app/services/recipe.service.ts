import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecipeModel} from "../interfaces/recipe.model";
import {CreateRecipeModel} from "../interfaces/createRecipe.model";
import {CommentModel} from "../interfaces/comment.model";
import {AddFavoriteRecipeModel} from "../interfaces/addFavoriteRecipeModel";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor(private http: HttpClient) { }

  getAllRecipes(): Observable<RecipeModel[]> {
    return this.http.get<RecipeModel[]>('/api/recipes/allrecipes');
  }

  createRecipe(createRecipeModel: CreateRecipeModel): Observable<number> {
    return this.http.post<number>('/api/recipes/createrecipe', createRecipeModel);
  }

  updateRecipe(id: number, createRecipeModel: CreateRecipeModel): Observable<void> {
    return this.http.put<void>(`/api/recipes/${id}`, createRecipeModel);
  }

  deleteRecipe(id: number): Observable<void> {
    return this.http.delete<void>(`/api/recipes/${id}`);
  }

  getRecipeById(id: number): Observable<RecipeModel> {
    return this.http.get<RecipeModel>(`/api/recipes/${id}`);
  }

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

  getCommentsByRecipeId(id:number): Observable<CommentModel[]> {
    return this.http.get<CommentModel[]>(`api/postedcomments/allcomments/${id}`);
  }

  addCommentToRecipe(commentModel: CommentModel): Observable<number> {
    return this.http.post<number>('/api/postedcomments/comment', commentModel);
  }

  addFavoriteRecipe(favoriteRecipeModel: AddFavoriteRecipeModel): Observable<number> {
    return this.http.post<number>('/api/favouriterecipes/addrecipetofavourite', favoriteRecipeModel);
  }

  uploadImage(file: File) : Observable<any> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post('/api/upload', formData);
  }
}

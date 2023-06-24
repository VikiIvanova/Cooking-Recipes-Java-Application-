import { Component } from '@angular/core';
import { RecipeModel } from "../../../interfaces/recipe.model";
import { RecipeService } from "../../../services/recipe.service";
import { Category } from "../../../interfaces/category";

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent {
  searchResults: RecipeModel[] = [];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.fetchAllRecipes();
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('username');
  }

  fetchAllRecipes(): void {
    this.recipeService.getAllRecipes()
      .subscribe(recipes => {
        this.searchResults = recipes;
      });
  }

  search(searchParams: { name: string, productName: string, category: Category }): void {
    const { name, productName, category } = searchParams;

    if (name || category || productName) {
      this.recipeService.searchRecipes(name, category, productName)
        .subscribe(recipes => {
          this.searchResults = recipes;
        });
    } else {
      this.fetchAllRecipes();
    }
  }
}

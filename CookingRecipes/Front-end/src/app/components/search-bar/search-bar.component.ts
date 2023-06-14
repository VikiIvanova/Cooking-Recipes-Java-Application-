import { Component } from '@angular/core';
import {RecipeModel} from "../../interfaces/recipe.model";
import {RecipeService} from "../../services/recipe.service";

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent {
  name: string | undefined;
  category: string | undefined;
  productName: string | undefined;

  searchResults: RecipeModel[] = [];

  constructor(private recipeService: RecipeService) { }

  search(): void {
    if (this.name || this.category || this.productName) {
      this.recipeService.searchRecipes(this.name, this.category, this.productName)
        .subscribe({
          next: recipes => {
            this.searchResults = recipes;
          },
          error: error => {
            console.error(error);
          }
        });
    } else {
      console.log("Please provide search parameters");
    }
  }

}

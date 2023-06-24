import { Component, OnInit } from '@angular/core';
import { RecipeModel } from '../../interfaces/recipe.model';
import { RecipeService } from '../../services/recipe.service';
import { Category } from '../../interfaces/category';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {
  name: string | undefined;
  productName: string | undefined;
  category: Category | undefined;

  searchResults: RecipeModel[] = [];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.search();
  }

  search(): void {
    if (this.name || this.category || this.productName) {
      this.recipeService.searchRecipes(this.name, this.category, this.productName)
        .subscribe(recipes => {
          this.searchResults = recipes;
        });
    } else {
      this.recipeService.getAllRecipes()
        .subscribe(recipes => {
          this.searchResults = recipes;
        });
    }
  }
}

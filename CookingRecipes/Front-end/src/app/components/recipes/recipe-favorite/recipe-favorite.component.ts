import { Component } from '@angular/core';
import { RecipeModel } from '../../../interfaces/recipe.model';
import { RecipeService } from '../../../services/recipe.service';

@Component({
  selector: 'app-recipe-favorite',
  templateUrl: './recipe-favorite.component.html',
  styleUrls: ['./recipe-favorite.component.css']
})
export class RecipeFavoriteComponent {
  favoriteRecipes: RecipeModel[] = [];
  public userId!: number;

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.fetchFavoriteRecipes();
  }

  fetchFavoriteRecipes(): void {
    const userId = Number(localStorage.getItem('id'));
    this.recipeService.getAllFavoriteRecipes(userId)
      .subscribe(recipeIds => {
        recipeIds.forEach(recipeId => {
          this.recipeService.getRecipeById(recipeId)
            .subscribe(recipe => {
              this.favoriteRecipes.push(recipe);
            });
        });
      });
  }
}

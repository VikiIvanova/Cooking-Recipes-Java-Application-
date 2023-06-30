import { Component, OnInit} from '@angular/core';
import {RecipeService} from "../../services/recipe.service";
import {RecipeModel} from "../../interfaces/recipe.model";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  recipeInformation!: RecipeModel[];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.recipeService.getAllRecipes().subscribe((recipes) => {
      this.recipeInformation = recipes;
    });
  }
}

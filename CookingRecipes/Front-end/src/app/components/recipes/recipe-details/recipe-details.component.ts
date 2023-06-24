import { Component, Input, OnInit } from '@angular/core';
import { RecipeModel } from '../../../interfaces/recipe.model';
import { RecipeService } from '../../../services/recipe.service';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  id!: number;
  recipeDetails?: RecipeModel;

  constructor(
    private service: RecipeService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.service.getRecipeById(this.id).subscribe((details) => {
      this.recipeDetails = details;
    });
  }
}

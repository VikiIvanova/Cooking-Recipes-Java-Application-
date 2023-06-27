import { Component, Input, OnInit } from '@angular/core';
import { RecipeModel } from '../../../interfaces/recipe.model';
import { RecipeService } from '../../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { Measure, MeasureMap } from '../../../interfaces/measure';
import {CommentModel} from "../../../interfaces/comment.model";

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css'],
})
export class RecipeDetailsComponent implements OnInit {
  id!: number;
  recipeDetails?: RecipeModel;
  recipeComments?: CommentModel[];
  public Measure = Measure;
  public MeasureMap = MeasureMap;

  constructor(
    private service: RecipeService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.service.getRecipeById(this.id).subscribe((details) => {
      this.recipeDetails = details;
    });
    this.service.getCommentsByRecipeId(this.id).subscribe((comments) => {
      this.recipeComments = comments;
      console.log(this.recipeComments);
    });
  }
}

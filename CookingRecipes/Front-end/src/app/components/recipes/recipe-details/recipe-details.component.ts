import {Component, Input, OnInit} from '@angular/core';
import {RecipeModel} from '../../../interfaces/recipe.model';
import {RecipeService} from '../../../services/recipe.service';
import {ActivatedRoute, Params} from '@angular/router';
import {Measure, MeasureMap} from '../../../interfaces/measure';
import {CommentModel} from '../../../interfaces/comment.model';
import {CommentDialogComponent} from '../../comment-dialog/comment-dialog.component';
import {MatDialog} from '@angular/material/dialog';
import {AddFavoriteRecipeModel} from "../../../interfaces/addFavoriteRecipeModel";
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css'],
})
export class RecipeDetailsComponent implements OnInit {
  id!: number;
  recipeDetails?: RecipeModel;
  recipeComments?: CommentModel[];
  public MeasureMap = MeasureMap;
  public userId?: number;

  imagePath?: string;

  constructor(
    private service: RecipeService,
    private route: ActivatedRoute,
    public dialog: MatDialog,
    private recipeService: RecipeService,
    private snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.service.getRecipeById(this.id).subscribe((details) => {
        this.recipeDetails = details;
      });
      this.service.getCommentsByRecipeId(this.id).subscribe((comments) => {
        this.recipeComments = comments;
      });
      this.service.getImagePathByRecipeId(this.id).subscribe((imageBlob) => {
        this.imagePath = URL.createObjectURL(imageBlob);
      });
    });

    const userId = localStorage.getItem('id');
    if (userId) {
      this.userId = +userId;
    }
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('username');
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CommentDialogComponent, {
      width: '450px',
      data: {comment: ''},
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        const commentModel: CommentModel = {
          recipeId: this.id,
          userId: this.userId!,
          comment: result,
        };

        this.recipeService.addCommentToRecipe(commentModel).subscribe((commentId) => {
          this.service.getCommentsByRecipeId(this.id).subscribe((comments) => {
            this.recipeComments = comments;
          });
        });
      }
    });
  }

  addLovers() {
    const favoriteRecipeModel: AddFavoriteRecipeModel = {
      recipeId: this.id,
      userId: this.userId!
    };

    this.recipeService.addFavoriteRecipe(favoriteRecipeModel).subscribe((result) => {
      if (result === -1) {
        this.snackBar.open('Рецептата вече е добавена към любими', 'Затвори', {
          duration: 3000,
        });
      } else {
        this.snackBar.open('Успешно добавихте рецептата в любими!', 'Затвори', {
          duration: 3000,
        });
      }
    });
  }
}

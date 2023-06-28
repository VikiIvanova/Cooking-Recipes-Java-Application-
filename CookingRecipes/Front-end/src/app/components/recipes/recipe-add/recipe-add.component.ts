import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators } from '@angular/forms';
import {Router} from "@angular/router";
import {RecipeService} from "../../../services/recipe.service";

@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.css']
})
export class RecipeAddComponent implements OnInit{
  addRecipeForm = new FormGroup({
    name: new FormControl(null, [Validators.required]),
    category: new FormControl(null,[Validators.required]),
    description: new FormControl(null, [Validators.required]),
    image: new FormControl(null, [Validators.required]),
  });
  selectedFile: File | undefined;

  constructor(private router: Router, private recipeService: RecipeService) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }


  uploadImage() {
    if (this.selectedFile) {
      console.log(this.selectedFile);
      this.recipeService.uploadImage(this.selectedFile).subscribe(
        {
          next: () => {
            console.log('Image uploaded successfully');
          },
          error: (error) => {
            console.error('Error uploading image', error);
          }
        }
      );
    }
  }


  ngOnInit(): void {}

  addRecipe(addRecipeForm: FormGroup) {
    if (addRecipeForm.valid) {

    }
  }

}

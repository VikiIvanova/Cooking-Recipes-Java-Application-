import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { RecipeService } from '../../../services/recipe.service';
import { CreateRecipeModel } from '../../../interfaces/createRecipe.model';

@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.css']
})
export class RecipeAddComponent implements OnInit {
  selectedFile: File | undefined;
  addRecipeForm!: FormGroup;
  products!: FormArray;
  public userId?: number;

  constructor(
    private router: Router,
    private recipeService: RecipeService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.addRecipeForm = this.formBuilder.group({
      name: '',
      category: '',
      description: '',
      image: '',
      products: this.formBuilder.array([this.createProduct()])
    });

    const userId = localStorage.getItem('id');
    if (userId) {
      this.userId = +userId;
    }
  }

  createProduct(): FormGroup {
    return this.formBuilder.group({
      name: '',
      quantity: '',
      measure: ''
    });
  }

  addProduct(): void {
    this.products = this.addRecipeForm.get('products') as FormArray;
    this.products.push(this.createProduct());
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadImage() {
    if (this.selectedFile) {
      this.recipeService.uploadImage(this.selectedFile).subscribe({
        next: () => {
          console.log('Image uploaded successfully');
        },
        error: (error) => {
          console.error('Error uploading image', error);
        }
      });
    }
  }

  addRecipe(addRecipeForm: FormGroup) {
    if (addRecipeForm.invalid) {
      return;
    }

    const createRecipe: CreateRecipeModel = {
      name: addRecipeForm.get('name')!.value,
      products: addRecipeForm.get('products')!.value,
      category: addRecipeForm.get('category')!.value,
      description: addRecipeForm.get('description')!.value,
      imagePath: this.selectedFile?.name,
      rate: 0,
      ownerId: this.userId
    } as CreateRecipeModel;

    this.recipeService.addRecipe(createRecipe).subscribe(() => {
      this.router.navigate(['homePage']);
    });
  }

}

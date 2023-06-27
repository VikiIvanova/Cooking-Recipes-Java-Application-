import {RecipeModel} from "./recipe.model";

export interface UserModel {
  id: number;
  username: string;
  email: string;
  password: string;
  recipes: RecipeModel;
  //favourites: FavouriteRecipe;
}

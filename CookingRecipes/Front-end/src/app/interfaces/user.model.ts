import {RecipeModel} from "./recipe.model";

export interface UserModel {
  id: string;
  username: string;
  email: string;
  password: string;
  recipes: RecipeModel;
  //favourites: FavouriteRecipe;
}

import {ProductModel} from "./product.model";
import {Category} from "./category";
import {UserModel} from "./user.model";

export interface CreateRecipeModel {
  name: string;
  products: ProductModel
  category: Category;
  description: string;
  rate: number;
  owner: UserModel;
}

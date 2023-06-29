import {ProductModel} from "./product.model";
import {Category} from "./category";

export interface CreateRecipeModel {
  name: string;
  products: ProductModel[];
  category: Category;
  description: string;
  imagePath: string;
  rate: number;
  ownerId: number;
}

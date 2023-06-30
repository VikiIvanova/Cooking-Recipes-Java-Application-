import { Category } from "./category";
import { ProductModel } from "./product.model";
import {CommentModel} from "./comment.model";

export interface RecipeModel {
  id: number;
  name: string;
  category: Category;
  products?: ProductModel[];
  imagePath: string;
  description: string;
  comments?: CommentModel[];
}

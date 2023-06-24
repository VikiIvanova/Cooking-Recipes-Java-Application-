import {Category} from "./category";

export interface RecipeModel {
  id: number;
  name: string;
  category: Category;
  productName: string;
  // image: any;
  description: string;

}

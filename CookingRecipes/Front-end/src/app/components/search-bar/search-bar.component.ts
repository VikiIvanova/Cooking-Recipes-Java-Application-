import { Component, Output, EventEmitter } from '@angular/core';
import { Category } from '../../interfaces/category';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent {
  name: string | undefined;
  productName: string | undefined;
  category: Category | undefined;

  @Output() searchEvent = new EventEmitter();

  search(): void {
    const searchParams = {
      name: this.name,
      productName: this.productName,
      category: this.category
    };

    this.searchEvent.emit(searchParams);
  }
}

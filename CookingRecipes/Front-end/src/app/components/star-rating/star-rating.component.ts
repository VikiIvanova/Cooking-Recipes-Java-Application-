import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent {
  @Input() rating: number = 0;
  @Output() ratingChange = new EventEmitter<number>();
  stars = [1, 2, 3, 4, 5];

  rateRecipe(rating: number) {
    this.rating = rating;
    this.ratingChange.emit(this.rating);
  }

  onStarHover(star: number) {
    console.log('Star hovered:', star);
  }
}

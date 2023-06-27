import { Pipe, PipeTransform } from '@angular/core';
import { Measure } from '../interfaces/measure';

@Pipe({
  name: 'measure'
})
export class MeasurePipe implements PipeTransform {
  transform(value: Measure): string {
    switch (value) {
      case Measure.GRAM:
        return 'гр';
      case Measure.MILLILITRES:
        return 'мл';
      case Measure.COUNT:
        return 'бр';
      default:
        return '';
    }
  }
}

export enum Measure {
  GRAM = 'гр',
  MILLILITRES = 'мл',
  COUNT = 'бр'
}
export const MeasureMap: { [key in Measure]: string } = {
  [Measure.GRAM]: 'гр',
  [Measure.MILLILITRES]: 'мл',
  [Measure.COUNT]: 'бр'
};


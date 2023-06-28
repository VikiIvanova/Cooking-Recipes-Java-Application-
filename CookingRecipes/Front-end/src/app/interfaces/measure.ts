export enum Measure {
  GRAM = 'GRAM',
  MILLILITRES = 'MILLILITRES',
  COUNT = 'COUNT'
}
export const MeasureMap: { [key in Measure]: string } = {
  [Measure.GRAM]: 'гр.',
  [Measure.MILLILITRES]: 'мл.',
  [Measure.COUNT]: 'бр.'
};



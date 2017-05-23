import { CurrencyPage } from './app.po';

describe('currency App', () => {
  let page: CurrencyPage;

  beforeEach(() => {
    page = new CurrencyPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

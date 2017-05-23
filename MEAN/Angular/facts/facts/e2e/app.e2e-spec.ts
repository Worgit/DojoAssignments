import { FactsPage } from './app.po';

describe('facts App', () => {
  let page: FactsPage;

  beforeEach(() => {
    page = new FactsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

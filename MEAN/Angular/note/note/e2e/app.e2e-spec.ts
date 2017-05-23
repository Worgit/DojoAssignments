import { NotePage } from './app.po';

describe('note App', () => {
  let page: NotePage;

  beforeEach(() => {
    page = new NotePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

import { LogregPage } from './app.po';

describe('logreg App', () => {
  let page: LogregPage;

  beforeEach(() => {
    page = new LogregPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

import { NavigationTabsModule } from './navigation-tabs.module';

describe('NavigationTabsModule', () => {
  let navigationTabsModule: NavigationTabsModule;

  beforeEach(() => {
    navigationTabsModule = new NavigationTabsModule();
  });

  it('should create an instance', () => {
    expect(navigationTabsModule).toBeTruthy();
  });
});

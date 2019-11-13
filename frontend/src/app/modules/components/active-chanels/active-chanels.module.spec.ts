import { ActiveChanelsModule } from './active-chanels.module';

describe('ActiveChanelsModule', () => {
  let activeChanelsModule: ActiveChanelsModule;

  beforeEach(() => {
    activeChanelsModule = new ActiveChanelsModule();
  });

  it('should create an instance', () => {
    expect(activeChanelsModule).toBeTruthy();
  });
});

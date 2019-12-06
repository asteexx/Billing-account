import { BalanceModule } from './balance.module';

describe('BalanceModule', () => {
  let balanceModule: BalanceModule;

  beforeEach(() => {
    balanceModule = new BalanceModule();
  });

  it('should create an instance', () => {
    expect(balanceModule).toBeTruthy();
  });
});

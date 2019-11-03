import { CreateChanelFormModule } from './create-chanel-form.module';

describe('CreateChanelFormModule', () => {
  let createChanelFormModule: CreateChanelFormModule;

  beforeEach(() => {
    createChanelFormModule = new CreateChanelFormModule();
  });

  it('should create an instance', () => {
    expect(createChanelFormModule).toBeTruthy();
  });
});

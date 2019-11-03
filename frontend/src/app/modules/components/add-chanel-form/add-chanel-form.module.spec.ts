import { AddChanelFormModule } from './add-chanel-form.module';

describe('AddChanelFormModule', () => {
  let addChanelFormModule: AddChanelFormModule;

  beforeEach(() => {
    addChanelFormModule = new AddChanelFormModule();
  });

  it('should create an instance', () => {
    expect(addChanelFormModule).toBeTruthy();
  });
});

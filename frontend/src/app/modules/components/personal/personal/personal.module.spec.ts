import { PersonalModule } from './personal.module';

describe('PersonalModule', () => {
  let personalModule: PersonalModule;

  beforeEach(() => {
    personalModule = new PersonalModule();
  });

  it('should create an instance', () => {
    expect(personalModule).toBeTruthy();
  });
});

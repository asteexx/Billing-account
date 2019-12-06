import { RegisterAdminModule } from './register-admin.module';

describe('RegisterAdminModule', () => {
  let registerAdminModule: RegisterAdminModule;

  beforeEach(() => {
    registerAdminModule = new RegisterAdminModule();
  });

  it('should create an instance', () => {
    expect(registerAdminModule).toBeTruthy();
  });
});

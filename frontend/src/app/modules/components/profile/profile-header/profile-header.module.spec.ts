import { ProfileHeaderModule } from './profile-header.module';

describe('ProfileHeaderModule', () => {
  let profileHeaderModule: ProfileHeaderModule;

  beforeEach(() => {
    profileHeaderModule = new ProfileHeaderModule();
  });

  it('should create an instance', () => {
    expect(profileHeaderModule).toBeTruthy();
  });
});

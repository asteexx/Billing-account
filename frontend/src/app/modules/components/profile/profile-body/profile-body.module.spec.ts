import { ProfileBodyModule } from './profile-body.module';

describe('ProfileBodyModule', () => {
  let profileBodyModule: ProfileBodyModule;

  beforeEach(() => {
    profileBodyModule = new ProfileBodyModule();
  });

  it('should create an instance', () => {
    expect(profileBodyModule).toBeTruthy();
  });
});

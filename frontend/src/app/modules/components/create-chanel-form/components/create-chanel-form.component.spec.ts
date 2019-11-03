import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateChanelFormComponent } from './create-chanel-form.component';

describe('CreateChanelFormComponent', () => {
  let component: CreateChanelFormComponent;
  let fixture: ComponentFixture<CreateChanelFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateChanelFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateChanelFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddChanelFormComponent } from './add-chanel-form.component';

describe('AddChanelFormComponent', () => {
  let component: AddChanelFormComponent;
  let fixture: ComponentFixture<AddChanelFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddChanelFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddChanelFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

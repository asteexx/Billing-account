import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveChanelsComponent } from './active-chanels.component';

describe('ActiveChanelsComponent', () => {
  let component: ActiveChanelsComponent;
  let fixture: ComponentFixture<ActiveChanelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActiveChanelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveChanelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

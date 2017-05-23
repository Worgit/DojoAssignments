import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublictaskComponent } from './publictask.component';

describe('PublictaskComponent', () => {
  let component: PublictaskComponent;
  let fixture: ComponentFixture<PublictaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublictaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublictaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

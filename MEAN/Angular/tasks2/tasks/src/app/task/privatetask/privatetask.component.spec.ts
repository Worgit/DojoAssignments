import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivatetaskComponent } from './privatetask.component';

describe('PrivatetaskComponent', () => {
  let component: PrivatetaskComponent;
  let fixture: ComponentFixture<PrivatetaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrivatetaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrivatetaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

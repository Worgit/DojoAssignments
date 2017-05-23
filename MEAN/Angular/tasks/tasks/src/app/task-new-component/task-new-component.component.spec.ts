import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskNewComponentComponent } from './task-new-component.component';

describe('TaskNewComponentComponent', () => {
  let component: TaskNewComponentComponent;
  let fixture: ComponentFixture<TaskNewComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskNewComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskNewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

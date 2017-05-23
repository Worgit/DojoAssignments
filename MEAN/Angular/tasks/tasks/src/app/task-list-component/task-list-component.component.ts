import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-task-list-component',
  templateUrl: './task-list-component.component.html',
  styleUrls: ['./task-list-component.component.css']
})
export class TaskListComponentComponent implements OnInit {
  @Input() tasks;
  constructor() { }

  ngOnInit() {
  }

}

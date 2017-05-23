import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-task-new-component',
  templateUrl: './task-new-component.component.html',
  styleUrls: ['./task-new-component.component.css']
})
export class TaskNewComponentComponent implements OnInit {
  task: string = "";
  @Output() taskEmitter = new EventEmitter();
  constructor() { }
  submit(){
    this.taskEmitter.emit(this.task);
  }
  ngOnInit() {
  }

}

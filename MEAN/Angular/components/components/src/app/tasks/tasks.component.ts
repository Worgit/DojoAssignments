import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  tasks: Array<string>;
  @Input() quotes;
  constructor() { }

  ngOnInit() {
    this.tasks = ["task1", "task2"]
  }

}

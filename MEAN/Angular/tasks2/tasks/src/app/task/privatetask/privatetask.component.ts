import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Task } from '../task';
@Component({
  selector: 'app-privatetask',
  templateUrl: './privatetask.component.html',
  styleUrls: ['./privatetask.component.css']
})
export class PrivatetaskComponent implements OnInit {
  tasks: Array<Task>
  constructor(private _taskService: TaskService) { }

  ngOnInit() {
    this.tasks = this._taskService.getPri();
  }

}

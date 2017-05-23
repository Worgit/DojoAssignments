import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Task } from '../task';
@Component({
  selector: 'app-publictask',
  templateUrl: './publictask.component.html',
  styleUrls: ['./publictask.component.css']
})
export class PublictaskComponent implements OnInit {
  tasks: Array<Task>
  constructor(private _taskService: TaskService) { }

  ngOnInit() {
    this.tasks = this._taskService.getPub();
  }

}

import { Injectable } from '@angular/core';
import { Task } from './task';
@Injectable()
export class TaskService {
  pubTasks: Array<Task> = [new Task("This is a public task")];
  priTasks: Array<Task> = [new Task("This is a private task")];
  constructor() { }
  getPri(){
    return (this.priTasks);
  }
  getPub(){
    return (this.pubTasks);
  }
}

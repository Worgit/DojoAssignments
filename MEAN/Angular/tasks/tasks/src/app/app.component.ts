import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  tasks: Array<string> = [];
  dataFromChild(eventData){
    this.tasks.push(eventData);
  }
}

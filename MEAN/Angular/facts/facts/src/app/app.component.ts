import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  sdate = new Date('Monday, January 5, 2015');
  bdate = new Date('8/3/2015, 12:00:00 AM');
  date = new Date();
  hdate = new Date('5/20/1990');
}

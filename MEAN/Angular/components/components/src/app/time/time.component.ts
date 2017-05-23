import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {
  date: Date;
  @Input() quotes;
  constructor() { }

  ngOnInit() {
    this.date = new Date();
  }

}

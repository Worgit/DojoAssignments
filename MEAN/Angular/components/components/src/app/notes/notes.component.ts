import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notes: Array<string>;
  @Input() quotes;
  constructor() { }

  ngOnInit() {
    this.notes = ["note1", "note2"];
  }

}

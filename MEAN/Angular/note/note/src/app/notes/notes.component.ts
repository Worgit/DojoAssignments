import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

  constructor() { }
  note: Note;
  edit: boolean = false;
  ngOnInit() {
  }
  getEdit(note){
    this.note = note;
    this.edit = true;
  }
  cancel(event){
    this.edit = false;
  }
}

import { Component, OnInit } from '@angular/core';
import { NoteService } from '../../note.service';
import { Note } from '../../note';
@Component({
  selector: 'app-note-new',
  templateUrl: './note-new.component.html',
  styleUrls: ['./note-new.component.css']
})
export class NoteNewComponent implements OnInit {
  constructor(private _noteService: NoteService) { }
  note: Note = new Note();
  ngOnInit() {
  }
  submit(){
    this._noteService.addNote(this.note);
  }
}

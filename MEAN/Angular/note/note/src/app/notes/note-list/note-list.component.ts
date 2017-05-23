import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NoteService } from '../../note.service';
import { Note } from '../../note';
@Component({
  selector: 'app-note-list',
  templateUrl: './note-list.component.html',
  styleUrls: ['./note-list.component.css']
})
export class NoteListComponent implements OnInit {

  constructor(private _noteService: NoteService) { }
  notes: Array<Note>;
  @Output() editEventEmitter = new EventEmitter();
  ngOnInit() {
    this.getNotes();
  }
  getNotes(){
    this.notes = this._noteService.getNotes();
    console.log(this.notes);
  }
  onDelete(note){
    this._noteService.deleteNote(note);
  }
  onEdit(note){
    this.editEventEmitter.emit(note);
  }
}

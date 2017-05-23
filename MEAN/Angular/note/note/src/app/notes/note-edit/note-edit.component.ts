import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NoteService } from '../../note.service';
import { Note } from '../../note';
@Component({
  selector: 'app-note-edit',
  templateUrl: './note-edit.component.html',
  styleUrls: ['./note-edit.component.css']
})
export class NoteEditComponent implements OnInit {

  constructor(private _noteService: NoteService) { }
  @Input() note;
  @Output() cancelEmitter = new EventEmitter();
  text:string = "";
  ngOnInit() {
  }
  submit(){
    this._noteService.editNote(this.note, this.text);
    this.cancelEmitter.emit(true);
  }
  cancel(){
    this.cancelEmitter.emit(true);
  }
}

import { Injectable } from '@angular/core';
import { Note } from './note';
@Injectable()
export class NoteService {
  notes: Array<Note> = [
    new Note('First'),
    new Note('Second')
  ]
  constructor() { }
  getNotes(){
    return this.notes;
  }
  addNote(note: Note){
    this.notes.push(note);
  }
  deleteNote(note: Note){
    let index = this.notes.indexOf(note)
    this.notes.splice(index, 1);
  }
  editNote(note: Note, text: string){
    let index = this.notes.indexOf(note)
    this.notes[index].note = text;
  }
}

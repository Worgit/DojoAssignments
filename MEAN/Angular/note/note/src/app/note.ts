export class Note {
  _id: number = Math.floor(Math.random()*100);
  note: string;
  dateCreated: Date;
  dateUpdated: Date;
  constructor(note: string = ""){
    this.note = note;
    this.dateCreated = new Date();
    this.dateUpdated = new Date();
  }

}

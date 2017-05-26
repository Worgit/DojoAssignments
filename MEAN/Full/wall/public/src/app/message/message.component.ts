import { Component, OnInit } from '@angular/core';
import { MessageService } from './message.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  messages: Array<any>;
  user: any;
  constructor(
    private _messageService: MessageService,
    private _router: Router) { }
  ngOnInit() {
    this.getCurrentUser();
    this.getAllMessages()
  }
  getCurrentUser(){
    this._messageService.getCurrent()
      .then( (user) => this.user = user)
      .catch( (err) => this._router.navigate(['/login']))
  }
  getAllMessages(){
    this._messageService.getAllMessages()
      .then( (messages) => this.messages = messages)
      .catch( (err) => console.log(err))
  }
  createMessage(formData){
    this._messageService.createMessage(formData.value)
      .then( (message) => {
        formData.reset()
        this.getAllMessages();
        console.log(message)
      })
      .catch( (err) => this._router.navigate(['/login']))
  }
  createComment(formData, message_id){
    this._messageService.createComment(formData.value, message_id)
      .then( () =>{
        this.getAllMessages();
      })
      .catch( (err) => console.log(err))
    formData.reset()
  }
}

import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs';
@Injectable()
export class MessageService {

  constructor(private _http:Http) { }
  getAllMessages(){
    return this._http.get('/api/messages')
      .map( (messages: Response) => messages.json())
      .toPromise()
  }
  createMessage(message){
    return this._http.post('/api/messages', message)
      .map( (message: Response) => message.json())
      .toPromise()
  }
  getCurrent(){
    return this._http.get('api/current')
    .map( (user: Response) => user.json())
    .toPromise()
  }
  createComment(comment, id){
    return this._http.post('/api/comments/' + id, comment)
      .map( (response: Response) => response.json())
      .toPromise()
  }
}

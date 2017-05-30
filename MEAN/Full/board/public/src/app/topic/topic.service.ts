import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs';
@Injectable()
export class TopicService {

  constructor(private _http: Http) { }

  getCurrentUser(){
    return this._http.get('/current')
    .map( (user: Response) => user.json())
    .toPromise()
  }

  getTopic(id){
    return this._http.get('/topic/' + id)
    .map( (topic: Response) => topic.json())
    .toPromise()
  }

  makePost(formData, id){
    return this._http.post('/topic/' + id + '/post', formData)
      .map( (post: Response) => post.json())
      .toPromise()
  }

  makeComment(formData, t_id, p_id){
    return this._http.post('/topic/' + t_id + '/post/' + p_id + '/comment', formData)
      .map( (comment: Response) => comment.json())
      .toPromise()
  }
}


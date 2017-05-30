import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs';
@Injectable()
export class DashboardService {

  constructor(private _http: Http) { }

  getCurrent(){
    return this._http.get('/current')
    .map( (user: Response) => user.json())
    .toPromise()
  }

  getTopics(){
    return this._http.get('/topics')
    .map( (user: Response) => user.json())
    .toPromise()
  }

  makePost(topic){
    return this._http.post('/topic', topic)
      .map( (newTopic: Response) => newTopic.json())
      .toPromise()
  }

}

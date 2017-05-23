import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs'
@Injectable()
export class FriendsService {

  constructor(private _http: Http) { }
  getFriends(){
    return this._http.get('/api/friends').map((friends: Response) => friends.json()).toPromise();
  }
  addFriend(friend){
    return this._http.post('/api/friends', friend).map((friends: Response) => friends.json()).toPromise();
  }
  getFriend(id){
    return this._http.get('/api/friends/' + id).map((friend: Response) => friend.json()).toPromise();
  }
  editFriend(friend){
    return this._http.put('/api/friends', friend).map((friends: Response) => friends.json()).toPromise();
  }
}

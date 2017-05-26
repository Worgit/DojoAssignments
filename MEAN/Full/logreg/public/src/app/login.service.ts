import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs'
@Injectable()
export class LoginService {
  constructor(private _http: Http) { }
  login(email){
    //console.log(email);
    return this._http.get('/api/login/' + email).map((friends: Response) => friends.json()).toPromise();
  }
  register(user){
    return this._http.post('/api/register', user).map((friends: Response) => friends.json()).toPromise();
  }
}

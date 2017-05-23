import { Injectable } from '@angular/core';
import { User } from './user';
@Injectable()
export class UserService {
  users: Array<User> = [];
  current: User;
  logged: boolean = false;
  limit: number = 0;
  constructor() { }
  addUser(user: User){
    this.users.push(user);
  }
  login(email: string){
    var check: boolean = false;
    if(this.limit >= 3){
      alert("Too Many Attempts");
    }
    else{
      for (var i = 0; i < this.users.length; i++){
        if(email == this.users[i].email){
          check = true;
          this.logged = true;
          this.limit = 0;
          this.current = this.users[i];
          alert("Welcome, " + this.users[i].first_name);
          break;
        }
      }
      if(!check){
        alert("Invalid Email");
        this.limit++;
      }
    }
  }
  getUser(){
    if(this.current != undefined){
      return (this.current);
    }
    else{
      return false;
    }
  }
}

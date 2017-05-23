import { Injectable } from '@angular/core';
import { User } from './user/user';

@Injectable()
export class UserService {
  users: Array<User> = [
    new User('Diana'),
    new User('Baxton'),
    new User('Klif')
  ]
  constructor() { }
  getUsers(){
    return this.users;
  }

}

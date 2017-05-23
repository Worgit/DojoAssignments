import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from './user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  constructor(private _userService: UserService) { }
  users: Array<User>;
  ngOnInit() {
    this.getUsers();

  }

  getUsers(){
    this.users = this._userService.getUsers();
    console.log(this.users);
  }

}

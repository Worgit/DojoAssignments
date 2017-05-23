import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';
import { User } from '../user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string ="";
  constructor(private _userService: UserService) { }

  ngOnInit() {
  }
  login(){
    this._userService.login(this.email);
  }
}

import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';
import { User } from '../user';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user: User = new User();
  constructor(private _userService: UserService) { }
  confirm: string;
  ngOnInit() {
  }
  onSubmit(){
    if(this.user.password != this.confirm){
      alert("passwords are not equal");
    }
    else{
      this._userService.addUser(this.user);
    }
  }
}

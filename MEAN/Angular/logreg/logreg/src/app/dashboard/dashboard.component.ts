import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';
import { User } from '../user';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user: any;
  check: boolean = false;
  constructor(private _userService: UserService) { }

  ngOnInit() {
    this.user = this._userService.getUser();
    if(this.user != false){
      this.check = true;
    }
  }

}

import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = new User();
  users = [];
  limit = 0;
  check = {email:""};
  onSubmit(){
    this.users.push(this.user);
    this.user = new User();
    console.log(this.users);
  }
  login(){
    var check: boolean = false;
    if(this.limit >= 3){
      alert("Too Many Attempts");
    }
    else{
      for (var i = 0; i < this.users.length; i++){
        if(this.check.email == this.users[i].email){
          alert("Welcome " + this.check.email + "!");
          check = true;
          this.limit = 0;
          break;
        }
      }
      if(!check){
        alert("Invalid Email");
        this.limit++;
      }
    }
  }
}

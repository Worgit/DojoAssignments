import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ LoginService ]
})
export class HomeComponent implements OnInit {
  user = {
    first_name: "",
    last_name: "",
    birthday: new Date(),
    email: "",
    password: ""
  };
  confirm: String = "";
  email =  "";
  logged = false;
  name = "";
  constructor(private _loginService: LoginService) { }

  ngOnInit() {
  }

  login(){
    //console.log(this.email);
    this._loginService.login(this.email)
      .then( user => {
        if(user == null){
          alert("invalid email");
        }
        else{
          console.log(user);
          console.log(user.first_name);
          this.name = user.first_name;
          alert("Hi " + user.first_name);
          this.logged = true;
        }
      })
      .catch(err => alert(err))
  }
  register(){
    if(this.confirm == this.user.password){
      this._loginService.register(this.user)
        .then( user => {
          if(user == null){
            alert("Registration Failed");
          }
          else{
            console.log(user);
            if(user.first_name == undefined){
              alert("Registration Failed");
            }
            else{
              this.name = user.first_name;
              alert("Hi " + user.first_name);
              this.logged = true;
            }
          }
        })
        .catch(err => alert(err))
    }
    else{
      alert("Passwords must match");
    }
  }
  logout(){
    this.name = "";
    this.logged = false;
  }
}

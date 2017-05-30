import { Component, OnInit } from '@angular/core';
import { DashboardService } from './dashboard.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  topics: Array<any>;
  errors: Array<any>;
  user: any;
  constructor(private _dashboardService: DashboardService, private _router: Router) { }

  ngOnInit() {
    this.getCurrentUser();
    this.getTopics();
  }

  getCurrentUser(){
    this._dashboardService.getCurrent()
      .then( (user) => this.user = user)
      .catch( (err) => this._router.navigate(['/login']))
  }

  getTopics(){
    console.log("*******")
    this._dashboardService.getTopics()
      .then( (topics) => {
        this.topics = topics
        console.log(this.topics);
      })
      .catch( (err) => {
        console.log(err)
        this.errors = err._body.split(",")
        console.log(this.errors);
      })
  }

  makeTopic(formData){
    console.log("*******7")
    this._dashboardService.makePost(formData.value)
      .then( (post) => {
        console.log("*******8")
        formData.reset()
        this.getTopics();
        console.log(post)
      })
      .catch( (err) => {
        console.log("*******9")
        console.log(err)
        this.errors = err._body.split(",")
        console.log(this.errors);
      })
  }

}

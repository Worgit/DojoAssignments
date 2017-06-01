import { Component, OnInit } from '@angular/core';
import { TopicService } from './topic.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.css']
})
export class TopicComponent implements OnInit {
  errors: any;
  topic: any;
  user: any;
  constructor(private _topicService: TopicService, private _router: Router, private _route: ActivatedRoute) {
    this._route.params.subscribe((param) => {
      this.getTopic(param.id);
    })
  }

  ngOnInit() {
    this.getCurrentUser();
  }

  getCurrentUser(){
    this._topicService.getCurrentUser()
      .then( (user) => this.user = user)
      .catch( (err) => this._router.navigate(['/login']))
  }

  getTopic(id){
    this._topicService.getTopic(id)
      .then( (topic) => this.topic = topic)
      .catch( (err) => this.errors = err._body)
  }

  makePost(formData){
    this._topicService.makePost(formData.value, this.topic._id)
      .then( () => this.getTopic(this.topic._id))
      .catch( (err) => this.errors = err._body)
  }
  makeComment(formData, post){
    this._topicService.makeComment(formData.value, this.topic._id, post._id)
      .then( () => this.getTopic(this.topic._id))
      .catch( (err) => this.errors = err._body)
  }
  like(post){
    this._topicService.like(this.topic._id, post._id)
      .then( () => this.getTopic(this.topic._id))
      .catch( (err) => this.errors = err._body)
  }
  dislike(post){
    this._topicService.dislike(this.topic._id, post._id)
      .then( () => this.getTopic(this.topic._id))
      .catch( (err) => this.errors = err._body)
  }


}

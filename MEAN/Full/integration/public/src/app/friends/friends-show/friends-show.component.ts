import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FriendsService } from '../friends.service';
@Component({
  selector: 'app-friends-show',
  templateUrl: './friends-show.component.html',
  styleUrls: ['./friends-show.component.css']
})
export class FriendsShowComponent implements OnInit {
  friend_id: String;
  friend = {};
  constructor(private _route: ActivatedRoute, private _friendsService: FriendsService) { }

  ngOnInit() {
    this._route.params.subscribe((param)=>{
      this.friend_id = param.id;
    })
    this.getFriend(this.friend_id);
  }
  getFriend(id){
    this._friendsService.getFriend(id)
      .then( friend => this.friend = friend)
      .catch(err => alert(err))
  }

}

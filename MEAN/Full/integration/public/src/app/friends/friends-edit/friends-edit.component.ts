import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FriendsService } from '../friends.service';
@Component({
  selector: 'app-friends-edit',
  templateUrl: './friends-edit.component.html',
  styleUrls: ['./friends-edit.component.css']
})
export class FriendsEditComponent implements OnInit {
  friend_id: String;
  friend;
  constructor(private _route: ActivatedRoute,
  private _friendsService: FriendsService,
  private router: Router) { }

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

  editFriend(){
    this._friendsService.editFriend(this.friend)
      .then(() => this.router.navigate(['/friends']))
      .catch( err => alert(err))
  }

}

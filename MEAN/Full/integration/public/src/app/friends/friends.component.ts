import { Component, OnInit } from '@angular/core';
import { FriendsService } from './friends.service';
@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  friends: Array<any>;
  constructor(private _friendsService: FriendsService) { }

  ngOnInit() {
    this.getAllFriends();
  }
  getAllFriends(){
    this._friendsService.getFriends()
      .then(friends => {
        console.log(friends);
        this.friends = friends})
      .catch( response => console.log(response))
  }

}

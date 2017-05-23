import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../friends.service';
@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.css']
})
export class FriendsListComponent implements OnInit {
  friends: Array<any>
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

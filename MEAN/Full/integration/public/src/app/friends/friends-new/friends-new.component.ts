import { Component, OnInit } from '@angular/core';
import { FriendsService } from './../friends.service';
import { RouterModule, Routes, Router } from '@angular/router';
@Component({
  selector: 'app-friends-new',
  templateUrl: './friends-new.component.html',
  styleUrls: ['./friends-new.component.css']
})
export class FriendsNewComponent implements OnInit {
  constructor(private _friendService: FriendsService, private router: Router) { }

  ngOnInit() {
  }
  addFriend(formData){
    this._friendService.addFriend(formData.value)
      .then( () => this.router.navigate(['/friends']))
      .catch( err => alert(err))
  }

}

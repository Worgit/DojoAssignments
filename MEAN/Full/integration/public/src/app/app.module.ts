import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing} from './app.routes'
import { AppComponent } from './app.component';
import { FriendsComponent } from './friends/friends.component';
import { FriendsService } from './friends/friends.service';
import { FriendsListComponent } from './friends/friends-list/friends-list.component';
import { FriendsNewComponent } from './friends/friends-new/friends-new.component';
import { FriendsEditComponent } from './friends/friends-edit/friends-edit.component';
import { FriendsShowComponent } from './friends/friends-show/friends-show.component';

@NgModule({
  declarations: [
    AppComponent,
    FriendsComponent,
    FriendsListComponent,
    FriendsNewComponent,
    FriendsEditComponent,
    FriendsShowComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [FriendsService],
  bootstrap: [AppComponent]
})
export class AppModule { }

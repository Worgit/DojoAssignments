import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routes';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './user/user.component';
import { TopicComponent } from './topic/topic.component';
import { LoginService } from './login/login.service';
import { DashboardService } from './dashboard/dashboard.service';
import { UserService } from './user/user.service';
import { TopicService } from './topic/topic.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    UserComponent,
    TopicComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [LoginService, DashboardService, UserService, TopicService],
  bootstrap: [AppComponent]
})
export class AppModule { }

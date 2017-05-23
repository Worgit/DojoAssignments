import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { TaskComponent } from './task/task.component';
import { PublictaskComponent } from './task/publictask/publictask.component';
import { PrivatetaskComponent } from './task/privatetask/privatetask.component';
import { TaskService } from './task/task.service';
import { routing } from './app.routes';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    PublictaskComponent,
    PrivatetaskComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }

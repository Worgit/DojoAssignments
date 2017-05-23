import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TaskListComponentComponent } from './task-list-component/task-list-component.component';
import { TaskNewComponentComponent } from './task-new-component/task-new-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponentComponent,
    TaskNewComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

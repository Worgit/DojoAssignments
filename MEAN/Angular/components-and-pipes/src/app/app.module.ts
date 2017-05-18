import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CurrencyComponent } from './currency/currency.component';
import { DateComponent } from './date/date.component';
import { TimeComponent } from './time/time.component';
import { DatetimeComponent } from './datetime/datetime.component';

@NgModule({
  declarations: [
    AppComponent,
    CurrencyComponent,
    DateComponent,
    TimeComponent,
    DatetimeComponent
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

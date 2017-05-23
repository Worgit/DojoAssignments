import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './weather/app.routes';
import { AppComponent } from './app.component';
import { WeatherComponent } from './weather/weather.component';
import { WindComponent } from './weather/wind/wind.component';
import { TempComponent } from './weather/temp/temp.component';
import { SkyComponent } from './weather/sky/sky.component';
import { HttpService } from './weather/http.service';
import { WeatherService } from './weather/weather.service';
@NgModule({
  declarations: [
    AppComponent,
    WeatherComponent,
    WindComponent,
    TempComponent,
    SkyComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [HttpService, WeatherService],
  bootstrap: [AppComponent]
})
export class AppModule { }

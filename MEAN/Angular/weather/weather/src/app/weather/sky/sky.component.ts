import { Component, OnInit, Input } from '@angular/core';
import { WeatherService } from '../weather.service';
@Component({
  selector: 'app-sky',
  templateUrl: './sky.component.html',
  styleUrls: ['./sky.component.css']
})
export class SkyComponent implements OnInit {
  weather = [];
  constructor(private _weatherService: WeatherService) { }

  ngOnInit() {
    this.weather = this._weatherService.getWeather();
  }

}


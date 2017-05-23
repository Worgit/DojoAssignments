import { Component, OnInit, Input } from '@angular/core';
import { WeatherService } from '../weather.service';
@Component({
  selector: 'app-temp',
  templateUrl: './temp.component.html',
  styleUrls: ['./temp.component.css']
})
export class TempComponent implements OnInit {
  weather = [];
  constructor(private _weatherService: WeatherService) { }

  ngOnInit() {
    this.weather = this._weatherService.getWeather();
  }

}


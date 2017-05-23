import { Component, OnInit, Input } from '@angular/core';
import { WeatherService } from '../weather.service';
@Component({
  selector: 'app-wind',
  templateUrl: './wind.component.html',
  styleUrls: ['./wind.component.css']
})
export class WindComponent implements OnInit {
  weather = [];
  constructor(private _weatherService: WeatherService) { }

  ngOnInit() {
    this.weather = this._weatherService.getWeather();
  }

}

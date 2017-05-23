import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';
import { WeatherService } from './weather.service';
@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  zipCode: string;
  constructor(private _httpService: HttpService, private _weatherService: WeatherService) { }
  ngOnInit() {
  }

  onSubmit(){
    this._httpService.retrieveTasks(this.zipCode).then( data => {
      console.log(data);
      this._weatherService.storeWeather(data);
    })
    .catch( err => { console.log(err); })
  }

}

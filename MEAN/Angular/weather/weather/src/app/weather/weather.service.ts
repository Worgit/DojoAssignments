import { Injectable } from '@angular/core';

@Injectable()
export class WeatherService {
  weather =  [];
  constructor() { }
  storeWeather(weather){
    this.weather = weather;
  }
  getWeather(){
    return this.weather;
  }
}

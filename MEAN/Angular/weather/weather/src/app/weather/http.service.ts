import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs';
@Injectable()
export class HttpService {

  constructor(private _http: Http) { }

  retrieveTasks(zipCode: string) {
    let link: string = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&units=imperial&appid=401e7dfeb65bb4d3f0939c6926461d72";
    return this._http.get(link).map(data=>data.json()).toPromise()
  }

}

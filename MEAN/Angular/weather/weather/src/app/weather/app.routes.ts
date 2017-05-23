import { Routes, RouterModule } from '@angular/router';
import { WeatherComponent } from './weather.component';
import { WindComponent } from './wind/wind.component';
import { TempComponent } from './temp/temp.component';
import { SkyComponent } from './sky/sky.component';
const APP_ROUTES: Routes = [
    { path: '', redirectTo: '/weather', pathMatch: 'full' },
    { path: 'weather', component: WeatherComponent },
    { path: 'wind', component: WindComponent },
    { path: 'temp', component: TempComponent },
    { path: 'sky', component: SkyComponent }
];
export const routing = RouterModule.forRoot(APP_ROUTES);

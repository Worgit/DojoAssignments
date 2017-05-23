import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TaskComponent } from './task/task.component';
import { PublictaskComponent } from './task/publictask/publictask.component';
import { PrivatetaskComponent } from './task/privatetask/privatetask.component';
const APP_ROUTES: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'tasks', component: TaskComponent, children:[
      { path: 'public', component: PublictaskComponent },
      { path: 'private', component: PrivatetaskComponent }
    ]}
];
export const routing = RouterModule.forRoot(APP_ROUTES);

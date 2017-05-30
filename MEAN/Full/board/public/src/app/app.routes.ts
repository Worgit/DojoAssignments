import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './user/user.component';
import { TopicComponent } from './topic/topic.component';


const APP_ROUTES: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'dashboard', component: DashboardComponent},
    { path: 'topic/:id', component: TopicComponent },
    { path: 'user/:id', component: UserComponent },
];
export const routing = RouterModule.forRoot(APP_ROUTES);

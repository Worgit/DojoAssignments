import { Routes, RouterModule } from '@angular/router';
import { MessageComponent } from './message/message.component';
import { LoginComponent } from './login/login.component';

const APP_ROUTES: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'messages', component: MessageComponent },
];
export const routing = RouterModule.forRoot(APP_ROUTES);

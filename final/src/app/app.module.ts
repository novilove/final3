import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { EventComponent } from './pages/event/event.component';
import { AdminComponent } from './pages/admin/admin.component';
import { LoginComponent } from './pages/login/login.component';
import { StartComponent } from './pages/start/start.component';
import { SiginUpComponent } from './pages/sigin-up/sigin-up.component';
import { WeventComponent } from './pages/wevent/wevent.component';
import { ComponentModule } from './components/component.module';



const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'usuario', component: UsuarioComponent },
  { path: 'event', component: EventComponent }, 
  { path: 'adminstrador', component: AdminComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inicio', component: StartComponent },
  { path: 'sigin-up',component: SiginUpComponent},
  { path: 'wevent',component: WeventComponent},
  {
    path: 'home',
    component: HomeComponent,
    data: { title: 'home' }
  },
  { path: '**',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsuarioComponent,
    EventComponent,
    AdminComponent,
    LoginComponent,
    StartComponent,
    SiginUpComponent,
    WeventComponent,
 
   
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }),
      FormsModule,
      ReactiveFormsModule,
      ComponentModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

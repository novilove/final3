import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { UsuarioComponent } from './component/usuario/usuario.component';
import { EventComponent } from './component/event/event.component';
import { AdminComponent } from './component/admin/admin.component';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
 
  {
    path: 'home',
    component: HomeComponent,
    data: { title: 'home' }
  },
  { path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  { path: '**', component:HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsuarioComponent,
    EventComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }),
      FormsModule,
      ReactiveFormsModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
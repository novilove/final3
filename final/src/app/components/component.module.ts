import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { NavbarComponent } from './navbar/navbar.component';
import { GraficoComponent } from './grafico/grafico.component';




@NgModule({
  declarations: [ 

    NavbarComponent,
    GraficoComponent
  ],
    
  exports:[
    GraficoComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    NgxChartsModule,
    BrowserAnimationsModule
   
  ]
})
export class ComponentModule { }

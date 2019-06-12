import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ButtonsComponent} from './buttons/buttons.component';
import {MaterialModule} from 'src/app/shared/material.module';
import {FlexboxComponent} from './flexbox/flexbox.component';


const routes: Routes = [
  {path: 'buttons', component: ButtonsComponent},
  {path: 'flexBox', component: FlexboxComponent},
  {path: '**', redirectTo: 'buttons'}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    MaterialModule
  ],
  exports: [RouterModule]
})
export class DemoRoutingModule { }

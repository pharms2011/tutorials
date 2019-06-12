import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MaterialModule} from '../shared/material.module';
import {FlexLayoutModule} from '@angular/flex-layout';

import { DemoRoutingModule } from './demo-routing.module';
import { ButtonsComponent } from './buttons/buttons.component';
import { FlexboxComponent } from './flexbox/flexbox.component';
import {MatButtonModule, MatCheckboxModule, MatIconModule} from '@angular/material';



@NgModule({
  declarations: [ButtonsComponent, FlexboxComponent],
  imports: [
    CommonModule,
    DemoRoutingModule,
    MaterialModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    FlexLayoutModule
  ]
})
export class DemoModule { }

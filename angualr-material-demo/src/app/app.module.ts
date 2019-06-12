import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';

import {Routes, RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import {MaterialModule} from './shared/material.module';
import {HttpClientModule} from '@angular/common/http';
import {ContactmanagerModule} from './contactmanager/contactmanager.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

const routes: Routes = [
  {path: 'contactmanager', loadChildren: './contactmanager/contactmanager.module#ContactmanagerModule'},
  {path: 'demo', loadChildren: './demo/demo.module#DemoModule'},
  {path: '**', redirectTo: 'contactmanager'}
];

@NgModule({
  schemas: [
    NO_ERRORS_SCHEMA
  ],
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ContactmanagerModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

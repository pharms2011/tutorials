import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { ContactmanagerAppComponent } from './contactmanager-app.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { MainContentComponent } from './components/main-content/main-content.component';
import { SideNavComponent } from './components/side-nav/side-nav.component';

import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatButtonModule, MatCardModule,
  MatCheckboxModule,
  MatIconModule,
  MatLineModule,
  MatListModule, MatProgressSpinnerModule, MatSelectModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';

import { MaterialModule } from '../shared/material.module';
import { UserService } from './services/user.service';
import { NotesComponent } from './components/notes/notes.component';
import { NewContactDialogComponent } from './components/new-contact-dialog/new-contact-dialog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  { path: '', component: ContactmanagerAppComponent,
    children: [
      { path: ':id', component: MainContentComponent},
      { path: '', component: MainContentComponent}
  ]},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [
    MaterialModule,
    CommonModule,
    MaterialModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    FlexLayoutModule,
    RouterModule.forChild(routes),
    MatSidenavModule,
    MatToolbarModule,
    HttpClientModule,
    MatLineModule,
    MatListModule,
    MatCardModule,
    MatProgressSpinnerModule,
    FormsModule,
    MatSelectModule,
    ReactiveFormsModule
  ],
  exports: [
    MaterialModule,
    CommonModule,
    MaterialModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    FlexLayoutModule,
    MatSidenavModule,
    MatToolbarModule,
    HttpClientModule,
    MatLineModule,
    MatListModule,
    MatCardModule,
    MatProgressSpinnerModule,
    FormsModule,
    MatSelectModule,
    ReactiveFormsModule
  ],
  declarations: [
    ToolbarComponent,
    MainContentComponent,
    SideNavComponent,
    ContactmanagerAppComponent,
    NotesComponent,
    NewContactDialogComponent
  ],
  entryComponents: [
    NewContactDialogComponent
  ],
  providers: [
    UserService
  ]
})
export class ContactmanagerModule { }

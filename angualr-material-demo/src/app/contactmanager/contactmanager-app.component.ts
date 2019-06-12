import { Component, OnInit } from '@angular/core';
import {MatIconRegistry} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-contactmanager-app',
  templateUrl: '' +
    '<app-side-nav></app-side-nav>' +
    '',
  styleUrls: []
})
export class ContactmanagerAppComponent implements OnInit {

  constructor( iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIconSet(
      sanitizer.bypassSecurityTrustResourceUrl('assets/avatars.svg'));
  }

  ngOnInit() {
  }

}

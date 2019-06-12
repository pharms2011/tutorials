import { Component, OnInit } from '@angular/core';
import {MatDialogRef, MatSnackBar} from '@angular/material';
import {User} from '../../models/user';
import {FormControl, ValidationErrors, Validators} from '@angular/forms';
import {UserService} from '../../services/user.service';

class FromControl {
  constructor(s: string, validationErrors: ValidationErrors[]) {

  }

}

@Component({
  selector: 'app-new-contact-dialog',
  templateUrl: './new-contact-dialog.component.html',
  styleUrls: ['./new-contact-dialog.component.css']
})
export class NewContactDialogComponent implements OnInit {
  name = new FormControl('', [Validators.required]);

  avatars = [
    'svg-1', 'svg-2', 'svg-3', 'svg-4'
  ];

  user: User;
  constructor(
    private dialogRef: MatDialogRef<NewContactDialogComponent>,
    private userService: UserService
  ) { }

  getErrorMessage() {
    return this.name.hasError('required') ? 'You must enter a value' :
      this.name.hasError('email') ? 'Not a valid email' :
        '';
  }
  ngOnInit() {
    this.user = new User();
  }

  save() {
    this.userService.addUser(this.user).then(user => {
      this.dialogRef.close(user);
    });
    this.dialogRef.close(this.user);
  }


  dismiss() {
    this.dialogRef.close(null);
  }
}

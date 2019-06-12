import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Observable} from 'rxjs';
import {User} from '../../models/user';
import {Router} from '@angular/router';
import {MatSidenav} from '@angular/material';

const SMALL_WIDTH_BREAKPOINT = 720;

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {

  private mediaMatcher: MediaQueryList = matchMedia('(max-width: ${SMALL_WIDTH_BREAKPOINT}px)');

  users: Observable<User[]>;
  constructor(private userService: UserService, private router: Router) {}

  @ViewChild(MatSidenav) sidenav: MatSidenav;

  ngOnInit() {
    this.users = this.userService.users;
    this.userService.loadAll();

    this.users.subscribe(data => {
      if (data.length > 0) {
        this.router.navigate(['contactmanager', data[0].id]);
      }
    });

    this.router.events.subscribe(() => {
      this.sidenav.close();
    });
  }

  isScreenSmall(): boolean {
    return this.mediaMatcher.matches;
  }

}

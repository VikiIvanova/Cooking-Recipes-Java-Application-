import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('username');
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['../']);
  }

  getUsername(): string {
    const usernameData = localStorage.getItem('username');
    if (usernameData) {
      const usernameObj = JSON.parse(usernameData);
      return usernameObj.username;
    }
    return '';
  }
}

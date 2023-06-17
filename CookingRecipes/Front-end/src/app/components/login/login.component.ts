import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { UserModel } from '../../interfaces/user.model';
//import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required]),
  });

  constructor(
    private router: Router,
    private service: UserService,
    // private snackBar: MatSnackBar
  ) {}

  login() {
    if (!this.loginForm.valid) {
      return;
    }

    this.service.getAllUsers().subscribe((users: UserModel[]) => {
      const matchedUser = users.find(
        (user) =>
          user.email === this.loginForm.controls['email'].value &&
          user.password === this.loginForm.controls['password'].value
      );

      if (matchedUser) {
        localStorage.setItem('username', JSON.stringify({ username: matchedUser.username }));
        localStorage.setItem('id', matchedUser.id);
        this.router.navigate(['homePage']).then(() => {
          window.location.reload();
        });
       }
      // else {
      //   this.snackBar.open('Грешен имейл или парола', 'Затвори', {
      //     duration: 3000,
      //     verticalPosition: 'top',
      //     panelClass: 'error-snackbar'
      //   });
      // }
    });
  }

  ngOnInit(): void {}
}

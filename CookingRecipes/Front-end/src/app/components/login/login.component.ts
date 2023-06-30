import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { UserModel } from '../../interfaces/user.model';
import { LoginUserModel } from '../../interfaces/loginUser.model';

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
    private service: UserService
  ) {}

  login() {
    if (!this.loginForm.valid) {
      return;
    }

    const loginUser = new LoginUserModel(
      this.loginForm.controls['email'].value,
      this.loginForm.controls['password'].value
    );

    this.service.loginUser(loginUser).subscribe(
      (loginUserId) => {
        if (loginUserId === -1) {
          this.loginForm.setErrors({wrongCredentials: true});
        } else {
          this.service.getUserById(loginUserId).subscribe(
            (matchedUser) => {
              localStorage.setItem('username', JSON.stringify({username: matchedUser.username}));
              this.service.getUserId(matchedUser.username).subscribe((userId: number) => {
                localStorage.setItem('id', userId.toString());
                this.router.navigate(['homePage']).then(() => {
                  window.location.reload();
                });
              });
            });
        }
      });
  }
  ngOnInit(): void {}
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CreateUserModel } from '../../interfaces/createUser.model';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  registerForm = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    username: new FormControl(null, [Validators.required]),
    password: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router, private userService: UserService) {}

  ngOnInit(): void {
    // Initialization code here
  }

  register(data: any) {
    if (!this.registerForm.valid) {
      return;
    }

    if (data) {
      const createUserModel: CreateUserModel = {
        username: data.username,
        email: data.email,
        password: data.password
      };

      this.userService.createUser(createUserModel);
      this.router.navigate(['login']);
    }
  }
}

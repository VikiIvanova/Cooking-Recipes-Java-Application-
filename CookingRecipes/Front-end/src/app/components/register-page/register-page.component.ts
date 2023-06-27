import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CreateUserModel } from "../../interfaces/createUser.model";

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

  ngOnInit(): void {}

  register(formData: any) {
    if (this.registerForm.invalid) {
      return;
    }

    const createUser = new CreateUserModel(formData.email, formData.username, formData.password);

    this.userService.createUser(createUser).subscribe(() => {
      this.router.navigate(['homePage']);
    });
  }
}

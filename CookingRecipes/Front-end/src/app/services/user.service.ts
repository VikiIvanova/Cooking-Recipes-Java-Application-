import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserModel } from "../interfaces/user.model";
import {CreateUserModel} from "../interfaces/createUser.model";
import {LoginUserModel} from "../interfaces/loginUser.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<UserModel[]> {
    return this.http.get<UserModel[]>('/api/users/allusers');
  }

  getUserById(id: number): Observable<UserModel> {
    return this.http.get<UserModel>(`/api/users/user/${id}`);
  }

  createUser(createUserModel: CreateUserModel): Observable<number> {
    return this.http.post<number>('/api/users/createuser', createUserModel);
  }

  updateUser(id: number, createUserModel: CreateUserModel): Observable<void> {
    return this.http.put<void>(`/api/users/${id}`, createUserModel);
  }

  loginUser(loginUserModel: LoginUserModel): Observable<number> {
    return this.http.post<number>('/api/users/login', loginUserModel);
  }

  getUserId(username: string): Observable<number> {
    return this.http.get<number>(`/api/users/getId?username=${username}`);
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserModel} from "../interfaces/user.model";
import {CreateUserModel} from "../interfaces/createUser.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<UserModel[]> {
    return this.http.get<UserModel[]>('/api/user/allusers');
  }

  createUser(createUserModel: CreateUserModel): Observable<number> {
    return this.http.post<number>('/api/user/createuser', createUserModel);
  }

  updateUser(id: number, createUserModel: CreateUserModel): Observable<void> {
    return this.http.put<void>(`/api/user/${id}`, createUserModel);
  }
}

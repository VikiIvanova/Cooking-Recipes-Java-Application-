export interface LoginUserModel {
  email: string;
  password: string;
}
export class LoginUserModel {
  constructor(
    public email: string,
    public password: string
  ) {
    this.email = email;
    this.password = password;
  }
}

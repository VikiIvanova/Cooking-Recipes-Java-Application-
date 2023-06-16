export interface CreateUserModel {
  email: string;
  username: string;
  password: string;
}
export class CreateUserModel {
  constructor(
    public email: string,
    public username: string,
    public password: string
  ) {
    this.email = email;
    this.username = username;
    this.password = password;
  }
}


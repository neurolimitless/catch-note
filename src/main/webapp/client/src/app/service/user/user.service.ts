import {Injectable} from "@angular/core";
import {User} from "../../models/user.model";
import {Http} from "@angular/http";

@Injectable()
export class UserService {

  private registrationUrl = "/users/registration";

  constructor(private http: Http) {
  }

  create(user: User) {
    return this.http.post(this.registrationUrl, user);
  }

}

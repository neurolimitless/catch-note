import {Component, OnInit} from "@angular/core";
import {User} from "../../models/user.model";
import {Http} from "@angular/http";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public user: User;
  public isVisible: boolean;

  public toggleRegisterForm(): void {
    this.isVisible = !this.isVisible;
  }

  constructor(private http: Http) {
  }

  ngOnInit() {
  }

  public register() {

  }

}

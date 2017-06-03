import {Component, OnInit} from "@angular/core";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public user: User;

  constructor() {
  }

  ngOnInit() {
  }

  public register() {

  }

}

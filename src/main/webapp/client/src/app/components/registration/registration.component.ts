import {Component, Input, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {UserService} from "../../service/user/user.service";
import {MdSnackBar} from "@angular/material";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {

  @Input()
  public model: any = {};
  private loading: boolean;

  constructor(private router: Router, private userService: UserService, private snackbar: MdSnackBar) {
  }

  ngOnInit() {
  }

  register() {
    this.loading = true;
    this.userService.create(this.model).subscribe(
      data => {
        this.snackbar.open('Successfully registered!', 'Ok', {duration: 3000});
        this.router.navigate(['/login']);
      },
      error => {
        let err = error.json();
        this.snackbar.open(err.message, '', {duration: 3000});
        this.model = {};
        this.loading = false;
      });
    this.loading = false;
  }
}

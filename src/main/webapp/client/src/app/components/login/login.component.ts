import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../service/auth/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Http} from "@angular/http";
import {RegistrationComponent} from "../registration/registration.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [RegistrationComponent]
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  loading: boolean;
  error = '';
  returnUrl: String = "";

  constructor(private router: Router, private http: Http, private  authService: AuthService, private route: ActivatedRoute,
              private registration: RegistrationComponent) {
  }

  ngOnInit() {
    this.route
      .queryParams
      .map(params => params['returnUrl'] || '/')
      .subscribe(url => this.returnUrl = url);
  }

  login() {
    this.loading = true;
    this.authService.login(this.username, this.password)
      .subscribe(() => {
        this.router.navigate(['/home']);
      }, this.handleError);
  }

  handleError(error) {
    console.log(error.status);
  }

  logout(): void {
    localStorage.removeItem('jwt');
  }

  openRegisterForm(): void {
    this.router.navigate(['/registration']);
  }

}

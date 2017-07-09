import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Http} from "@angular/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  loading: boolean;
  error = '';
  returnUrl: String = "";

  constructor(private router: Router, private http: Http, private  authService: AuthService, private route: ActivatedRoute) {
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

}

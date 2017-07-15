import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../service/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.authService.checkCredentials();
  }

  logout() {
    localStorage.removeItem("jwt");
    this.router.navigate(["/login"]);
  }

}

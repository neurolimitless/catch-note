import {Injectable} from "@angular/core";
import {Headers, Http, Response} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import {Router} from "@angular/router";


@Injectable()
export class AuthService {

  private authUrl = '/login';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http, private router: Router) {
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl, JSON.stringify({name: username, password: password}),
      {headers: this.headers}).map((response: Response) => {
      let token = response.json() && response.json().token;
      if (token) {
        localStorage.setItem('user', JSON.stringify({username: username, token: token}));
        return true;
      } else {
        return false;
      }
    }).catch((error: any) => Observable.throw(error || 'Server error'));
  }

  logout() {
    localStorage.removeItem("user");
    this.router.navigate(['login']);
  }

  checkCredentials() {
    if (localStorage.getItem("user") === null) {
      this.router.navigate(['login']);
    }
  }

}

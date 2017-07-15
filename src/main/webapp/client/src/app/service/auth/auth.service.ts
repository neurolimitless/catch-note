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
  private headers = new Headers({'Content-Type': 'application/json', 'Accept': 'application/json'});

  constructor(private http: Http, private router: Router) {
  }

  login(username: string, password: string): Observable<Response> {
    let loginRequest = JSON.stringify({name: username, password: password});
    return this.http.post(this.authUrl, loginRequest, {headers: this.headers})
      .do(resp => {
        localStorage.setItem('jwt', resp.headers.get('x-auth-token'));
      });
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

  logout(): void {
    localStorage.removeItem('jwt');
  }

  checkCredentials() {
    if (localStorage.getItem("jwt") === null) {
      this.router.navigate(['login']);
    }
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }

}

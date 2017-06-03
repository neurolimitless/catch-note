import {Component} from "@angular/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public username: string;
  public password: string;

  public login(): any {
    alert(this.username + ' : ' + this.password);
  }
}

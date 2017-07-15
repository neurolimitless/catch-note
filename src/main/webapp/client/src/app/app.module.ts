import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {RegistrationComponent} from "./components/registration/registration.component";
import {LoginComponent} from "./components/login/login.component";
import {RouterModule} from "@angular/router";
import {RoutingModule} from "./components/routing/routing.module";
import {AuthService} from "./service/auth/auth.service";
import {HomeComponent} from "./components/home/home.component";
import {AuthGuard} from "./service/auth-guard";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {UserService} from "./service/user/user.service";
import {MdSnackBarModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([]),
    RoutingModule,
    MdSnackBarModule,
    BrowserAnimationsModule
  ],
  exports: [
    MdSnackBarModule
  ],
  providers: [AuthService, UserService, AuthGuard,
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}

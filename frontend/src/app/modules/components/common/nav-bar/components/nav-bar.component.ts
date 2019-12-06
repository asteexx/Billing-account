import {Component, OnInit} from "@angular/core";
import {LoginModel} from "../models/login.model";
import {StorageService} from "../../../../../services/security/storage.service";
import {AuthToken, UserService} from "../../../../../services/security/user-service";
import {UserModel} from "../models/user.model";

@Component({
  selector: "app-nav-bar",
  templateUrl: "./nav-bar.component.html",
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public loginModel: LoginModel = {};
  public showCheckYourSetDataAlert: boolean = false;

  constructor(private storageService: StorageService,
              private userService: UserService) {
  }

  ngOnInit() {
  }

  public onSubmit(): void {
    this.userService.generateToken(this.loginModel)
      .subscribe((authToken: AuthToken) => {
        if (authToken.token) {
          this.storageService.setToken(authToken.token);
          // var token = 'eyJ0eXAiO... /// jwt token';
          // var decoded = jwt_decode(token);
          // console.log(decoded);
          this.userService.getAuthorizedUser()
            .subscribe((userModel: UserModel) => {
              this.storageService.setCurrentUser(userModel);
            });
        }
      }, (error) => {
        if (error.status === 401) {
          this.showCheckYourSetDataAlert = true;
        } else {
          alert(error.message);
        }
      });

  }

  public logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
  }

}

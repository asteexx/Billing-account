import {Injectable} from "@angular/core";
import {UserModel} from "../../modules/components/common/nav-bar/models/user.model";
import {User} from "../../modules/components/registration-form/models/user";


@Injectable()
export class StorageService {

  private readonly TOKEN_KEY: string = "token";
  private readonly CURRENT_USER: string = "currentUser";

  private currentUser: UserModel;

  public setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  public setCurrentUser(currentUser: UserModel): void {
    this.currentUser = currentUser;
    localStorage.setItem(this.CURRENT_USER, JSON.stringify(currentUser));
  }

  public setUser(currentUser: User): void {
    localStorage.setItem(this.CURRENT_USER, JSON.stringify(currentUser));
  }

  public getUser(): User {
    return this.currentUser || JSON.parse(localStorage.getItem(this.CURRENT_USER));
  }

  public getCurrentUser(): UserModel {
    return this.currentUser || JSON.parse(localStorage.getItem(this.CURRENT_USER));
  }

  public getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY);

  }

  public clearToken(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
  }
}

import {Component, Input} from "@angular/core";
import {NavBarModule} from "../../../modules/components/common/nav-bar/nav-bar.module";

@Component({
  selector: "app-dropdown",
  templateUrl: "./dropdown.component.html",
  styleUrls:[ "./dropdown.component.css"]
})
export class DropdownComponent {

  @Input()
  dropdownItems: NavBarModule[] = [];

  @Input()
  dropdownId: string;

  @Input()
  dropdownTitle: string;

  public isOpened: boolean = false;
}

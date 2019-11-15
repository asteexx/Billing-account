import {Component, EventEmitter, Input, Output} from "@angular/core";

@Component({
  selector: "app-btn",
  templateUrl: "./button.component.html",
  styleUrls: ['./button.component.css']
})
export class ButtonComponent {

  @Input()
  text: string;

  @Input()
  className: string = '';


  @Input()
  cardPrice: number;

  @Input()
  type: string = "";

  @Output()
  clickChange: EventEmitter<void> = new EventEmitter<void>();

  constructor() {

    console.log(this.className);
  }
}

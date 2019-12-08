import {Component, EventEmitter, Input, Output} from "@angular/core";

@Component({
  selector: "app-btn",
  templateUrl: "./button.component.html",
  styleUrls: ['./button.component.css']
})
export class ButtonComponent {

  @Input()
  class: string;

  @Input()
  text: string;

  @Input()
  ngClass: string;

  @Input()
  cardPrice: number;

  @Input()
  type: string = "";

  @Input()
  disabled: string;

  @Output()
  clickChange: EventEmitter<void> = new EventEmitter<void>();


}

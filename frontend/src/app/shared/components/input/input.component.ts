import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent  {
  @Input()
  inputLabel: string;
  @Input()
  placeholder: string;
  @Input()
  name: string;
  @Input()
  value: string;
  @Input()
  inputType: string;
}

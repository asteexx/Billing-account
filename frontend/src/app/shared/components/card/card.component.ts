import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  cardHeader: string;
  @Input()
  cardTitle: string;
  @Input()
  cardBody: string;
  @Input()
  cardPrice: number;



  constructor() { }

  ngOnInit() {
  }

}

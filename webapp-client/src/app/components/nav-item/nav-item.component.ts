import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'nav-item',
  template: `<div class="container-fluid" (click)="onItemSelect(this)">
                {{navItem.title | translate}}
            </div>`,
  styleUrls: []
})
export class NavItemComponent implements OnInit {

  @Input() navItem={};
  @Output() itemSelect=new EventEmitter();

  constructor() { }

  ngOnInit() {
  }
  onItemSelect(){
    console.log("item selected::"+this.navItem);
    this.itemSelect.next(this.navItem);
  }

}

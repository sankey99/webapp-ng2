import { Component, OnInit, Input} from '@angular/core';
import {  Router } from '@angular/router';

@Component({
  selector: 'left-nav',
  template: `<div class="left-nav">
  	    <div>
          <nav-item
            class="container-fluid"
            [navItem]="navItem"
            *ngFor="let navItem of navItems; let i = index"
            (itemSelect)="onItemSelect($event, i)"
          >
          </nav-item>
        </div>
	  </div>`
  // , styleUrls: []
})
export class LeftNavComponent implements OnInit {
  
  // @Input() navItems={};
// TODO - set navItems dynamically from app/module
 navItems=[
      {title:"Feature1.title", url:"/feature1"},
      {title:"Feature2.title", url:"/feature2"},
      {title:"Intro.title", url:"/intro"}
  ];

  constructor(private router: Router) { }

  ngOnInit() {
  }
  onItemSelect(item){
       this.router.navigateByUrl(item.url);
  }

}

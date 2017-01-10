import { Component, OnInit } from '@angular/core';
import {SharedService} from '../../app/shared/shared.service';

@Component({
  selector: 'app-feature1',
  templateUrl: './feature1.component.html',
  styleUrls: ['./feature1.component.css']
})
export class Feature1Component implements OnInit {
  public showLeftNav=false;
  constructor(private sharedService:SharedService) { }

   hideLeftNav(): void {
    this.sharedService.setLeftNav(false);
  }

  ngOnInit(): void {
    this.hideLeftNav();
  }
}

import { Component, OnInit } from '@angular/core';
import {TranslateService} from 'ng2-translate';
import {SharedService} from '../../../app/shared/shared.service';
@Component({
  selector: 'top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  constructor(private translate: TranslateService, private sharedService: SharedService) {
  }

  ngOnInit() {
  }

}

import { Component, OnInit, Input } from '@angular/core';
import {TranslateService} from 'ng2-translate';
import {SharedService} from '../app/shared/shared.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app works!';
   showLeftNav:Boolean;
  
   constructor(private translate: TranslateService, private sharedService: SharedService) {
        translate.addLangs(['en', 'fr']);
        translate.setDefaultLang('en');

        let browserLang = translate.getBrowserLang();
        translate.use(browserLang.match(/en|fr/) ? browserLang : 'en');
  }
  
  getShowLeftNav(): void {
    this.sharedService.isLeftNav().then(showLeftNav => this.showLeftNav = showLeftNav);
  }
  
  setShowLeftNav(show:boolean){
    this.showLeftNav=show;
  }

  ngOnInit(): void {
    this.getShowLeftNav();
  }
  
}

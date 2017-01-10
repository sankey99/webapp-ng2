import { Injectable } from '@angular/core';

@Injectable()
export class SharedService {
  showLeftNav: Boolean;
  constructor(){
    this.showLeftNav=true;
  }
  isLeftNav(): Promise<Boolean> {
    return Promise.resolve(this.showLeftNav);
  }
  public setLeftNav(showLeftNav:Boolean) {
    this.showLeftNav= showLeftNav;
  }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AlertModule } from 'ng2-bootstrap';

import { SharedModule } from './shared/shared.module';
import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { Feature1Component } from './feature1/feature1.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeComponent } from './home/home.component';
import { IntroComponent } from './intro/intro.component';
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { LeftNavComponent } from './components/left-nav/left-nav.component';
import { NavItemComponent } from './components/nav-item/nav-item.component';


@NgModule({
  declarations: [
    AppComponent,
    Feature1Component,
    NotFoundComponent,
    HomeComponent,
    IntroComponent,
    TopBarComponent,
    LeftNavComponent,
    NavItemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AlertModule.forRoot(),
	  SharedModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

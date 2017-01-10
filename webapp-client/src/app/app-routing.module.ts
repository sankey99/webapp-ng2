import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent }   from './home/home.component';
import { Feature1Component }   from './feature1/feature1.component';
import { AppComponent }  from './app.component';
import { NotFoundComponent }  from './not-found/not-found.component';
import { IntroComponent }  from './intro/intro.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home',  component: HomeComponent },
  { path: 'feature1',  component: Feature1Component },
  { path: 'intro',  component: IntroComponent },
  { path: '**',  component: NotFoundComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

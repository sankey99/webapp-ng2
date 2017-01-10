import { NgModule } from '@angular/core';
import { HttpModule, Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { TranslateModule, TranslateLoader, TranslateStaticLoader, MissingTranslationHandler } from 'ng2-translate';


export function createTranslateLoader(http: Http) {
  return new TranslateStaticLoader(http, './assets/i18n', '.json');
}

export class MyMissingTranslationHandler extends MissingTranslationHandler {
  handle(key: any) {
    return 'missing key: [' +key.key + ']';
  }
}


@NgModule({
  imports: [
    HttpModule,
    TranslateModule.forRoot(
      {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [Http]
      }
    )
  ],
  exports: [TranslateModule],
  providers: [
     { provide: MissingTranslationHandler, useClass: MyMissingTranslationHandler }
  ],
})
export class AppTranslateModule { }

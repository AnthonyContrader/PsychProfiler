import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { GatewaySharedModule } from 'app/shared';
import {
  CandComponent,
  CandDetailComponent,
  CandUpdateComponent,
  CandDeletePopupComponent,
  CandDeleteDialogComponent,
  candRoute,
  candPopupRoute
} from './';

const ENTITY_STATES = [...candRoute, ...candPopupRoute];

@NgModule({
  imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [CandComponent, CandDetailComponent, CandUpdateComponent, CandDeleteDialogComponent, CandDeletePopupComponent],
  entryComponents: [CandComponent, CandUpdateComponent, CandDeleteDialogComponent, CandDeletePopupComponent],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Micro1CandModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}

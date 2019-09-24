import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { GatewaySharedModule } from 'app/shared';
import {
  QuestComponent,
  QuestDetailComponent,
  QuestUpdateComponent,
  QuestDeletePopupComponent,
  QuestDeleteDialogComponent,
  questRoute,
  questPopupRoute
} from './';

const ENTITY_STATES = [...questRoute, ...questPopupRoute];

@NgModule({
  imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [QuestComponent, QuestDetailComponent, QuestUpdateComponent, QuestDeleteDialogComponent, QuestDeletePopupComponent],
  entryComponents: [QuestComponent, QuestUpdateComponent, QuestDeleteDialogComponent, QuestDeletePopupComponent],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Micro2QuestModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}

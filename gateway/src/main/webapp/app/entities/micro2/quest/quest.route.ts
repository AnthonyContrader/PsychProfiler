import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Quest } from 'app/shared/model/micro2/quest.model';
import { QuestService } from './quest.service';
import { QuestComponent } from './quest.component';
import { QuestDetailComponent } from './quest-detail.component';
import { QuestUpdateComponent } from './quest-update.component';
import { QuestDeletePopupComponent } from './quest-delete-dialog.component';
import { IQuest } from 'app/shared/model/micro2/quest.model';

@Injectable({ providedIn: 'root' })
export class QuestResolve implements Resolve<IQuest> {
  constructor(private service: QuestService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IQuest> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Quest>) => response.ok),
        map((quest: HttpResponse<Quest>) => quest.body)
      );
    }
    return of(new Quest());
  }
}

export const questRoute: Routes = [
  {
    path: '',
    component: QuestComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'gatewayApp.micro2Quest.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: QuestDetailComponent,
    resolve: {
      quest: QuestResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro2Quest.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: QuestUpdateComponent,
    resolve: {
      quest: QuestResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro2Quest.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: QuestUpdateComponent,
    resolve: {
      quest: QuestResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro2Quest.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const questPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: QuestDeletePopupComponent,
    resolve: {
      quest: QuestResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro2Quest.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];

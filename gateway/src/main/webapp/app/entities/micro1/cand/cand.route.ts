import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Cand } from 'app/shared/model/micro1/cand.model';
import { CandService } from './cand.service';
import { CandComponent } from './cand.component';
import { CandDetailComponent } from './cand-detail.component';
import { CandUpdateComponent } from './cand-update.component';
import { CandDeletePopupComponent } from './cand-delete-dialog.component';
import { ICand } from 'app/shared/model/micro1/cand.model';

@Injectable({ providedIn: 'root' })
export class CandResolve implements Resolve<ICand> {
  constructor(private service: CandService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ICand> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Cand>) => response.ok),
        map((cand: HttpResponse<Cand>) => cand.body)
      );
    }
    return of(new Cand());
  }
}

export const candRoute: Routes = [
  {
    path: '',
    component: CandComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'gatewayApp.micro1Cand.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CandDetailComponent,
    resolve: {
      cand: CandResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro1Cand.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CandUpdateComponent,
    resolve: {
      cand: CandResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro1Cand.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CandUpdateComponent,
    resolve: {
      cand: CandResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro1Cand.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const candPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: CandDeletePopupComponent,
    resolve: {
      cand: CandResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'gatewayApp.micro1Cand.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];

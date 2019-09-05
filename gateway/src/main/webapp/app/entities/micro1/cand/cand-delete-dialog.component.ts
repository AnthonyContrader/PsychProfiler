import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICand } from 'app/shared/model/micro1/cand.model';
import { CandService } from './cand.service';

@Component({
  selector: 'jhi-cand-delete-dialog',
  templateUrl: './cand-delete-dialog.component.html'
})
export class CandDeleteDialogComponent {
  cand: ICand;

  constructor(protected candService: CandService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.candService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'candListModification',
        content: 'Deleted an cand'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-cand-delete-popup',
  template: ''
})
export class CandDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cand }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CandDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.cand = cand;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/cand', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/cand', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}

import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IQuest } from 'app/shared/model/micro2/quest.model';
import { QuestService } from './quest.service';

@Component({
  selector: 'jhi-quest-delete-dialog',
  templateUrl: './quest-delete-dialog.component.html'
})
export class QuestDeleteDialogComponent {
  quest: IQuest;

  constructor(protected questService: QuestService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.questService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'questListModification',
        content: 'Deleted an quest'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-quest-delete-popup',
  template: ''
})
export class QuestDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ quest }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(QuestDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.quest = quest;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/quest', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/quest', { outlets: { popup: null } }]);
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

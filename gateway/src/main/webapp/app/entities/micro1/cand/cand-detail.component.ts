import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICand } from 'app/shared/model/micro1/cand.model';

@Component({
  selector: 'jhi-cand-detail',
  templateUrl: './cand-detail.component.html'
})
export class CandDetailComponent implements OnInit {
  cand: ICand;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cand }) => {
      this.cand = cand;
    });
  }

  previousState() {
    window.history.back();
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IQuest } from 'app/shared/model/micro2/quest.model';

@Component({
  selector: 'jhi-quest-detail',
  templateUrl: './quest-detail.component.html'
})
export class QuestDetailComponent implements OnInit {
  quest: IQuest;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ quest }) => {
      this.quest = quest;
    });
  }

  previousState() {
    window.history.back();
  }
}

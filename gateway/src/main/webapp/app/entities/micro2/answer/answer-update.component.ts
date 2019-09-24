import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IAnswer, Answer } from 'app/shared/model/micro2/answer.model';
import { AnswerService } from './answer.service';
import { IQuest } from 'app/shared/model/micro2/quest.model';
import { QuestService } from 'app/entities/micro2/quest';

@Component({
  selector: 'jhi-answer-update',
  templateUrl: './answer-update.component.html'
})
export class AnswerUpdateComponent implements OnInit {
  isSaving: boolean;

  quests: IQuest[];

  editForm = this.fb.group({
    id: [],
    cand: [null, [Validators.required]],
    ans: [null, [Validators.required]],
    answer_questId: [null, Validators.required]
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected answerService: AnswerService,
    protected questService: QuestService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ answer }) => {
      this.updateForm(answer);
    });
    this.questService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IQuest[]>) => mayBeOk.ok),
        map((response: HttpResponse<IQuest[]>) => response.body)
      )
      .subscribe((res: IQuest[]) => (this.quests = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(answer: IAnswer) {
    this.editForm.patchValue({
      id: answer.id,
      cand: answer.cand,
      ans: answer.ans,
      answer_questId: answer.answer_questId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const answer = this.createFromForm();
    if (answer.id !== undefined) {
      this.subscribeToSaveResponse(this.answerService.update(answer));
    } else {
      this.subscribeToSaveResponse(this.answerService.create(answer));
    }
  }

  private createFromForm(): IAnswer {
    return {
      ...new Answer(),
      id: this.editForm.get(['id']).value,
      cand: this.editForm.get(['cand']).value,
      ans: this.editForm.get(['ans']).value,
      answer_questId: this.editForm.get(['answer_questId']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAnswer>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackQuestById(index: number, item: IQuest) {
    return item.id;
  }
}

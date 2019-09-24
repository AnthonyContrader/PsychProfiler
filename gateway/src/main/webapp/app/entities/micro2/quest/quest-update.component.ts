import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IQuest, Quest } from 'app/shared/model/micro2/quest.model';
import { QuestService } from './quest.service';

@Component({
  selector: 'jhi-quest-update',
  templateUrl: './quest-update.component.html'
})
export class QuestUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    args: [null, [Validators.required]],
    quest: [null, [Validators.required]],
    ans1: [null, [Validators.required]],
    ans2: [null, [Validators.required]],
    ans3: [null, [Validators.required]],
    ans4: [null, [Validators.required]]
  });

  constructor(protected questService: QuestService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ quest }) => {
      this.updateForm(quest);
    });
  }

  updateForm(quest: IQuest) {
    this.editForm.patchValue({
      id: quest.id,
      args: quest.args,
      quest: quest.quest,
      ans1: quest.ans1,
      ans2: quest.ans2,
      ans3: quest.ans3,
      ans4: quest.ans4
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const quest = this.createFromForm();
    if (quest.id !== undefined) {
      this.subscribeToSaveResponse(this.questService.update(quest));
    } else {
      this.subscribeToSaveResponse(this.questService.create(quest));
    }
  }

  private createFromForm(): IQuest {
    return {
      ...new Quest(),
      id: this.editForm.get(['id']).value,
      args: this.editForm.get(['args']).value,
      quest: this.editForm.get(['quest']).value,
      ans1: this.editForm.get(['ans1']).value,
      ans2: this.editForm.get(['ans2']).value,
      ans3: this.editForm.get(['ans3']).value,
      ans4: this.editForm.get(['ans4']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IQuest>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}

import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ICand, Cand } from 'app/shared/model/micro1/cand.model';
import { CandService } from './cand.service';

@Component({
  selector: 'jhi-cand-update',
  templateUrl: './cand-update.component.html'
})
export class CandUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    surname: [null, [Validators.required]],
    age: [null, [Validators.required]],
    experience: [null, [Validators.required]],
    username: [null, []]
  });

  constructor(protected candService: CandService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ cand }) => {
      this.updateForm(cand);
    });
  }

  updateForm(cand: ICand) {
    this.editForm.patchValue({
      id: cand.id,
      name: cand.name,
      surname: cand.surname,
      age: cand.age,
      experience: cand.experience,
      username: cand.username
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const cand = this.createFromForm();
    if (cand.id !== undefined) {
      this.subscribeToSaveResponse(this.candService.update(cand));
    } else {
      this.subscribeToSaveResponse(this.candService.create(cand));
    }
  }

  private createFromForm(): ICand {
    return {
      ...new Cand(),
      id: this.editForm.get(['id']).value,
      name: this.editForm.get(['name']).value,
      surname: this.editForm.get(['surname']).value,
      age: this.editForm.get(['age']).value,
      experience: this.editForm.get(['experience']).value,
      username: this.editForm.get(['username']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICand>>) {
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

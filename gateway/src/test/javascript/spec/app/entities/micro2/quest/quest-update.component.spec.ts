/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { QuestUpdateComponent } from 'app/entities/micro2/quest/quest-update.component';
import { QuestService } from 'app/entities/micro2/quest/quest.service';
import { Quest } from 'app/shared/model/micro2/quest.model';

describe('Component Tests', () => {
  describe('Quest Management Update Component', () => {
    let comp: QuestUpdateComponent;
    let fixture: ComponentFixture<QuestUpdateComponent>;
    let service: QuestService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [QuestUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(QuestUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(QuestUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(QuestService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Quest(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new Quest();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});

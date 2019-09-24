/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { CandUpdateComponent } from 'app/entities/micro1/cand/cand-update.component';
import { CandService } from 'app/entities/micro1/cand/cand.service';
import { Cand } from 'app/shared/model/micro1/cand.model';

describe('Component Tests', () => {
  describe('Cand Management Update Component', () => {
    let comp: CandUpdateComponent;
    let fixture: ComponentFixture<CandUpdateComponent>;
    let service: CandService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [CandUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CandUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CandUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CandService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Cand(123);
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
        const entity = new Cand();
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

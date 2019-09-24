/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AnswerDetailComponent } from 'app/entities/micro2/answer/answer-detail.component';
import { Answer } from 'app/shared/model/micro2/answer.model';

describe('Component Tests', () => {
  describe('Answer Management Detail Component', () => {
    let comp: AnswerDetailComponent;
    let fixture: ComponentFixture<AnswerDetailComponent>;
    const route = ({ data: of({ answer: new Answer(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [AnswerDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(AnswerDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(AnswerDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.answer).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

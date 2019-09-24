/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { QuestDetailComponent } from 'app/entities/micro2/quest/quest-detail.component';
import { Quest } from 'app/shared/model/micro2/quest.model';

describe('Component Tests', () => {
  describe('Quest Management Detail Component', () => {
    let comp: QuestDetailComponent;
    let fixture: ComponentFixture<QuestDetailComponent>;
    const route = ({ data: of({ quest: new Quest(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [QuestDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(QuestDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(QuestDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.quest).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

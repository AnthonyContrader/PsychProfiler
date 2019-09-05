/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { CandDetailComponent } from 'app/entities/micro1/cand/cand-detail.component';
import { Cand } from 'app/shared/model/micro1/cand.model';

describe('Component Tests', () => {
  describe('Cand Management Detail Component', () => {
    let comp: CandDetailComponent;
    let fixture: ComponentFixture<CandDetailComponent>;
    const route = ({ data: of({ cand: new Cand(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [CandDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CandDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CandDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cand).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

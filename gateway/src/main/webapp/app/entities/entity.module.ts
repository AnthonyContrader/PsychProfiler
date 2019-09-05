import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'cand',
        loadChildren: () => import('./micro1/cand/cand.module').then(m => m.Micro1CandModule)
      },
      {
        path: 'job',
        loadChildren: () => import('./micro1/job/job.module').then(m => m.Micro1JobModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}

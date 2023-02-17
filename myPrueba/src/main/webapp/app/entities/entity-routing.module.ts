import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'rencimiento',
        data: { pageTitle: 'pruebaRendimientoApp.rencimiento.home.title' },
        loadChildren: () => import('./rencimiento/rencimiento.module').then(m => m.RencimientoModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}

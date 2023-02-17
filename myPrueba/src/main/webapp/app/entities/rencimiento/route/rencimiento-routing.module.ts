import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { RencimientoComponent } from '../list/rencimiento.component';
import { RencimientoDetailComponent } from '../detail/rencimiento-detail.component';
import { RencimientoUpdateComponent } from '../update/rencimiento-update.component';
import { RencimientoRoutingResolveService } from './rencimiento-routing-resolve.service';
import { ASC } from 'app/config/navigation.constants';

const rencimientoRoute: Routes = [
  {
    path: '',
    component: RencimientoComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: RencimientoDetailComponent,
    resolve: {
      rencimiento: RencimientoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: RencimientoUpdateComponent,
    resolve: {
      rencimiento: RencimientoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: RencimientoUpdateComponent,
    resolve: {
      rencimiento: RencimientoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(rencimientoRoute)],
  exports: [RouterModule],
})
export class RencimientoRoutingModule {}

import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { RencimientoComponent } from './list/rencimiento.component';
import { RencimientoDetailComponent } from './detail/rencimiento-detail.component';
import { RencimientoUpdateComponent } from './update/rencimiento-update.component';
import { RencimientoDeleteDialogComponent } from './delete/rencimiento-delete-dialog.component';
import { RencimientoRoutingModule } from './route/rencimiento-routing.module';

@NgModule({
  imports: [SharedModule, RencimientoRoutingModule],
  declarations: [RencimientoComponent, RencimientoDetailComponent, RencimientoUpdateComponent, RencimientoDeleteDialogComponent],
})
export class RencimientoModule {}

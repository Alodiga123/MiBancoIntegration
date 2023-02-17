import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { IRencimiento } from '../rencimiento.model';
import { RencimientoService } from '../service/rencimiento.service';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';

@Component({
  templateUrl: './rencimiento-delete-dialog.component.html',
})
export class RencimientoDeleteDialogComponent {
  rencimiento?: IRencimiento;

  constructor(protected rencimientoService: RencimientoService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.rencimientoService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}

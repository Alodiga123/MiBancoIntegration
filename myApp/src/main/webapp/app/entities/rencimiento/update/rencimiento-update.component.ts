import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { RencimientoFormService, RencimientoFormGroup } from './rencimiento-form.service';
import { IRencimiento } from '../rencimiento.model';
import { RencimientoService } from '../service/rencimiento.service';

@Component({
  selector: 'jhi-rencimiento-update',
  templateUrl: './rencimiento-update.component.html',
})
export class RencimientoUpdateComponent implements OnInit {
  isSaving = false;
  rencimiento: IRencimiento | null = null;

  editForm: RencimientoFormGroup = this.rencimientoFormService.createRencimientoFormGroup();

  constructor(
    protected rencimientoService: RencimientoService,
    protected rencimientoFormService: RencimientoFormService,
    protected activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ rencimiento }) => {
      this.rencimiento = rencimiento;
      if (rencimiento) {
        this.updateForm(rencimiento);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const rencimiento = this.rencimientoFormService.getRencimiento(this.editForm);
    if (rencimiento.id !== null) {
      this.subscribeToSaveResponse(this.rencimientoService.update(rencimiento));
    } else {
      this.subscribeToSaveResponse(this.rencimientoService.create(rencimiento));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IRencimiento>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(rencimiento: IRencimiento): void {
    this.rencimiento = rencimiento;
    this.rencimientoFormService.resetForm(this.editForm, rencimiento);
  }
}

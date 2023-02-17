import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRencimiento } from '../rencimiento.model';

@Component({
  selector: 'jhi-rencimiento-detail',
  templateUrl: './rencimiento-detail.component.html',
})
export class RencimientoDetailComponent implements OnInit {
  rencimiento: IRencimiento | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ rencimiento }) => {
      this.rencimiento = rencimiento;
    });
  }

  previousState(): void {
    window.history.back();
  }
}

import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IRencimiento } from '../rencimiento.model';
import { RencimientoService } from '../service/rencimiento.service';

@Injectable({ providedIn: 'root' })
export class RencimientoRoutingResolveService implements Resolve<IRencimiento | null> {
  constructor(protected service: RencimientoService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IRencimiento | null | never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((rencimiento: HttpResponse<IRencimiento>) => {
          if (rencimiento.body) {
            return of(rencimiento.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(null);
  }
}

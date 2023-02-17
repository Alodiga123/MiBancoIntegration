import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IRencimiento, NewRencimiento } from '../rencimiento.model';

export type PartialUpdateRencimiento = Partial<IRencimiento> & Pick<IRencimiento, 'id'>;

export type EntityResponseType = HttpResponse<IRencimiento>;
export type EntityArrayResponseType = HttpResponse<IRencimiento[]>;

@Injectable({ providedIn: 'root' })
export class RencimientoService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/rencimientos');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(rencimiento: NewRencimiento): Observable<EntityResponseType> {
    return this.http.post<IRencimiento>(this.resourceUrl, rencimiento, { observe: 'response' });
  }

  update(rencimiento: IRencimiento): Observable<EntityResponseType> {
    return this.http.put<IRencimiento>(`${this.resourceUrl}/${this.getRencimientoIdentifier(rencimiento)}`, rencimiento, {
      observe: 'response',
    });
  }

  partialUpdate(rencimiento: PartialUpdateRencimiento): Observable<EntityResponseType> {
    return this.http.patch<IRencimiento>(`${this.resourceUrl}/${this.getRencimientoIdentifier(rencimiento)}`, rencimiento, {
      observe: 'response',
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IRencimiento>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IRencimiento[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getRencimientoIdentifier(rencimiento: Pick<IRencimiento, 'id'>): number {
    return rencimiento.id;
  }

  compareRencimiento(o1: Pick<IRencimiento, 'id'> | null, o2: Pick<IRencimiento, 'id'> | null): boolean {
    return o1 && o2 ? this.getRencimientoIdentifier(o1) === this.getRencimientoIdentifier(o2) : o1 === o2;
  }

  addRencimientoToCollectionIfMissing<Type extends Pick<IRencimiento, 'id'>>(
    rencimientoCollection: Type[],
    ...rencimientosToCheck: (Type | null | undefined)[]
  ): Type[] {
    const rencimientos: Type[] = rencimientosToCheck.filter(isPresent);
    if (rencimientos.length > 0) {
      const rencimientoCollectionIdentifiers = rencimientoCollection.map(
        rencimientoItem => this.getRencimientoIdentifier(rencimientoItem)!
      );
      const rencimientosToAdd = rencimientos.filter(rencimientoItem => {
        const rencimientoIdentifier = this.getRencimientoIdentifier(rencimientoItem);
        if (rencimientoCollectionIdentifiers.includes(rencimientoIdentifier)) {
          return false;
        }
        rencimientoCollectionIdentifiers.push(rencimientoIdentifier);
        return true;
      });
      return [...rencimientosToAdd, ...rencimientoCollection];
    }
    return rencimientoCollection;
  }
}

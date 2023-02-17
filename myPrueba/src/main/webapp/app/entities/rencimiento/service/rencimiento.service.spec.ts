import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IRencimiento } from '../rencimiento.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../rencimiento.test-samples';

import { RencimientoService } from './rencimiento.service';

const requireRestSample: IRencimiento = {
  ...sampleWithRequiredData,
};

describe('Rencimiento Service', () => {
  let service: RencimientoService;
  let httpMock: HttpTestingController;
  let expectedResult: IRencimiento | IRencimiento[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(RencimientoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should create a Rencimiento', () => {
      // eslint-disable-next-line @typescript-eslint/no-unused-vars
      const rencimiento = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(rencimiento).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a Rencimiento', () => {
      const rencimiento = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(rencimiento).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a Rencimiento', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of Rencimiento', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a Rencimiento', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addRencimientoToCollectionIfMissing', () => {
      it('should add a Rencimiento to an empty array', () => {
        const rencimiento: IRencimiento = sampleWithRequiredData;
        expectedResult = service.addRencimientoToCollectionIfMissing([], rencimiento);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(rencimiento);
      });

      it('should not add a Rencimiento to an array that contains it', () => {
        const rencimiento: IRencimiento = sampleWithRequiredData;
        const rencimientoCollection: IRencimiento[] = [
          {
            ...rencimiento,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addRencimientoToCollectionIfMissing(rencimientoCollection, rencimiento);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a Rencimiento to an array that doesn't contain it", () => {
        const rencimiento: IRencimiento = sampleWithRequiredData;
        const rencimientoCollection: IRencimiento[] = [sampleWithPartialData];
        expectedResult = service.addRencimientoToCollectionIfMissing(rencimientoCollection, rencimiento);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(rencimiento);
      });

      it('should add only unique Rencimiento to an array', () => {
        const rencimientoArray: IRencimiento[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const rencimientoCollection: IRencimiento[] = [sampleWithRequiredData];
        expectedResult = service.addRencimientoToCollectionIfMissing(rencimientoCollection, ...rencimientoArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const rencimiento: IRencimiento = sampleWithRequiredData;
        const rencimiento2: IRencimiento = sampleWithPartialData;
        expectedResult = service.addRencimientoToCollectionIfMissing([], rencimiento, rencimiento2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(rencimiento);
        expect(expectedResult).toContain(rencimiento2);
      });

      it('should accept null and undefined values', () => {
        const rencimiento: IRencimiento = sampleWithRequiredData;
        expectedResult = service.addRencimientoToCollectionIfMissing([], null, rencimiento, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(rencimiento);
      });

      it('should return initial array if no Rencimiento is added', () => {
        const rencimientoCollection: IRencimiento[] = [sampleWithRequiredData];
        expectedResult = service.addRencimientoToCollectionIfMissing(rencimientoCollection, undefined, null);
        expect(expectedResult).toEqual(rencimientoCollection);
      });
    });

    describe('compareRencimiento', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareRencimiento(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareRencimiento(entity1, entity2);
        const compareResult2 = service.compareRencimiento(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareRencimiento(entity1, entity2);
        const compareResult2 = service.compareRencimiento(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareRencimiento(entity1, entity2);
        const compareResult2 = service.compareRencimiento(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});

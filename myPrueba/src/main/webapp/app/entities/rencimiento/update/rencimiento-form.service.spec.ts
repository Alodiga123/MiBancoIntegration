import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../rencimiento.test-samples';

import { RencimientoFormService } from './rencimiento-form.service';

describe('Rencimiento Form Service', () => {
  let service: RencimientoFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RencimientoFormService);
  });

  describe('Service methods', () => {
    describe('createRencimientoFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createRencimientoFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            cedulaBeneficiario: expect.any(Object),
            telefonoEmisor: expect.any(Object),
            fechaHora: expect.any(Object),
          })
        );
      });

      it('passing IRencimiento should create a new form with FormGroup', () => {
        const formGroup = service.createRencimientoFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            cedulaBeneficiario: expect.any(Object),
            telefonoEmisor: expect.any(Object),
            fechaHora: expect.any(Object),
          })
        );
      });
    });

    describe('getRencimiento', () => {
      it('should return NewRencimiento for default Rencimiento initial value', () => {
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        const formGroup = service.createRencimientoFormGroup(sampleWithNewData);

        const rencimiento = service.getRencimiento(formGroup) as any;

        expect(rencimiento).toMatchObject(sampleWithNewData);
      });

      it('should return NewRencimiento for empty Rencimiento initial value', () => {
        const formGroup = service.createRencimientoFormGroup();

        const rencimiento = service.getRencimiento(formGroup) as any;

        expect(rencimiento).toMatchObject({});
      });

      it('should return IRencimiento', () => {
        const formGroup = service.createRencimientoFormGroup(sampleWithRequiredData);

        const rencimiento = service.getRencimiento(formGroup) as any;

        expect(rencimiento).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IRencimiento should not enable id FormControl', () => {
        const formGroup = service.createRencimientoFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewRencimiento should disable id FormControl', () => {
        const formGroup = service.createRencimientoFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

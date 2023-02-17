import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IRencimiento, NewRencimiento } from '../rencimiento.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IRencimiento for edit and NewRencimientoFormGroupInput for create.
 */
type RencimientoFormGroupInput = IRencimiento | PartialWithRequiredKeyOf<NewRencimiento>;

type RencimientoFormDefaults = Pick<NewRencimiento, 'id'>;

type RencimientoFormGroupContent = {
  id: FormControl<IRencimiento['id'] | NewRencimiento['id']>;
  cedulaBeneficiario: FormControl<IRencimiento['cedulaBeneficiario']>;
  telefonoEmisor: FormControl<IRencimiento['telefonoEmisor']>;
  fechaHora: FormControl<IRencimiento['fechaHora']>;
};

export type RencimientoFormGroup = FormGroup<RencimientoFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class RencimientoFormService {
  createRencimientoFormGroup(rencimiento: RencimientoFormGroupInput = { id: null }): RencimientoFormGroup {
    const rencimientoRawValue = {
      ...this.getFormDefaults(),
      ...rencimiento,
    };
    return new FormGroup<RencimientoFormGroupContent>({
      id: new FormControl(
        { value: rencimientoRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      cedulaBeneficiario: new FormControl(rencimientoRawValue.cedulaBeneficiario),
      telefonoEmisor: new FormControl(rencimientoRawValue.telefonoEmisor, {
        validators: [Validators.required, Validators.maxLength(14)],
      }),
      fechaHora: new FormControl(rencimientoRawValue.fechaHora, {
        validators: [Validators.required, Validators.maxLength(30)],
      }),
    });
  }

  getRencimiento(form: RencimientoFormGroup): IRencimiento | NewRencimiento {
    return form.getRawValue() as IRencimiento | NewRencimiento;
  }

  resetForm(form: RencimientoFormGroup, rencimiento: RencimientoFormGroupInput): void {
    const rencimientoRawValue = { ...this.getFormDefaults(), ...rencimiento };
    form.reset(
      {
        ...rencimientoRawValue,
        id: { value: rencimientoRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): RencimientoFormDefaults {
    return {
      id: null,
    };
  }
}

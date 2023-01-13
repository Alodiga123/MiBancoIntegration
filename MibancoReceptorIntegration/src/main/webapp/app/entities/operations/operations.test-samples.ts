import { IOperations, NewOperations } from './operations.model';

export const sampleWithRequiredData: IOperations = {
  id: 99528,
};

export const sampleWithPartialData: IOperations = {
  id: 19387,
  monto: 'cross-platform enhan',
  bancoEmisor: 'Ghan',
  referencia: 'País Camino',
  fechaHora: 'Acero Account',
};

export const sampleWithFullData: IOperations = {
  id: 61565,
  cedulaBeneficiario: 'out-of-the-box c',
  telefonoEmisor: 'Genérico',
  telefonoBeneficiario: 'Forint navigat',
  monto: 'Borders Monitorizado',
  bancoEmisor: 'card',
  concepto: 'synthesize Cliente',
  referencia: 'SMTP',
  fechaHora: 'FTP connect',
};

export const sampleWithNewData: NewOperations = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

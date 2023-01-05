import { IOperations, NewOperations } from './operations.model';

export const sampleWithRequiredData: IOperations = {
  id: 99528,
};

export const sampleWithPartialData: IOperations = {
  id: 19387,
  monto: 'cross-platform enhan',
  bancoEmisor: 'Guam',
  referencia: 'Virginia Divide',
  fechaHora: 'Steel Account',
};

export const sampleWithFullData: IOperations = {
  id: 61565,
  cedulaBeneficiario: 'out-of-the-box c',
  telefonoEmisor: 'Awesome',
  telefonoBeneficiario: 'Forint navigat',
  monto: 'Borders Multi-channe',
  bancoEmisor: 'card',
  concepto: 'synthesize Investor',
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

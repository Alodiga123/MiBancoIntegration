import { IRencimiento, NewRencimiento } from './rencimiento.model';

export const sampleWithRequiredData: IRencimiento = {
  id: 27592,
  telefonoEmisor: 'Alabama index',
  fechaHora: 'Harbors',
};

export const sampleWithPartialData: IRencimiento = {
  id: 80034,
  cedulaBeneficiario: 39529,
  telefonoEmisor: 'Lead',
  fechaHora: 'Chips',
};

export const sampleWithFullData: IRencimiento = {
  id: 41867,
  cedulaBeneficiario: 381,
  telefonoEmisor: 'blue programmi',
  fechaHora: 'Forward firewall magenta',
};

export const sampleWithNewData: NewRencimiento = {
  telefonoEmisor: 'magenta',
  fechaHora: 'repurpose info-mediaries Glove',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

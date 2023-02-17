export interface IRencimiento {
  id: number;
  cedulaBeneficiario?: number | null;
  telefonoEmisor?: string | null;
  fechaHora?: string | null;
}

export type NewRencimiento = Omit<IRencimiento, 'id'> & { id: null };

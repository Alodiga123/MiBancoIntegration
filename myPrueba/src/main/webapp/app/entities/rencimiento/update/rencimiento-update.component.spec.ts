import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { RencimientoFormService } from './rencimiento-form.service';
import { RencimientoService } from '../service/rencimiento.service';
import { IRencimiento } from '../rencimiento.model';

import { RencimientoUpdateComponent } from './rencimiento-update.component';

describe('Rencimiento Management Update Component', () => {
  let comp: RencimientoUpdateComponent;
  let fixture: ComponentFixture<RencimientoUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let rencimientoFormService: RencimientoFormService;
  let rencimientoService: RencimientoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [RencimientoUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(RencimientoUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(RencimientoUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    rencimientoFormService = TestBed.inject(RencimientoFormService);
    rencimientoService = TestBed.inject(RencimientoService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const rencimiento: IRencimiento = { id: 456 };

      activatedRoute.data = of({ rencimiento });
      comp.ngOnInit();

      expect(comp.rencimiento).toEqual(rencimiento);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IRencimiento>>();
      const rencimiento = { id: 123 };
      jest.spyOn(rencimientoFormService, 'getRencimiento').mockReturnValue(rencimiento);
      jest.spyOn(rencimientoService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ rencimiento });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: rencimiento }));
      saveSubject.complete();

      // THEN
      expect(rencimientoFormService.getRencimiento).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(rencimientoService.update).toHaveBeenCalledWith(expect.objectContaining(rencimiento));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IRencimiento>>();
      const rencimiento = { id: 123 };
      jest.spyOn(rencimientoFormService, 'getRencimiento').mockReturnValue({ id: null });
      jest.spyOn(rencimientoService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ rencimiento: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: rencimiento }));
      saveSubject.complete();

      // THEN
      expect(rencimientoFormService.getRencimiento).toHaveBeenCalled();
      expect(rencimientoService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IRencimiento>>();
      const rencimiento = { id: 123 };
      jest.spyOn(rencimientoService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ rencimiento });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(rencimientoService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RencimientoDetailComponent } from './rencimiento-detail.component';

describe('Rencimiento Management Detail Component', () => {
  let comp: RencimientoDetailComponent;
  let fixture: ComponentFixture<RencimientoDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RencimientoDetailComponent],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: { data: of({ rencimiento: { id: 123 } }) },
        },
      ],
    })
      .overrideTemplate(RencimientoDetailComponent, '')
      .compileComponents();
    fixture = TestBed.createComponent(RencimientoDetailComponent);
    comp = fixture.componentInstance;
  });

  describe('OnInit', () => {
    it('Should load rencimiento on init', () => {
      // WHEN
      comp.ngOnInit();

      // THEN
      expect(comp.rencimiento).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});

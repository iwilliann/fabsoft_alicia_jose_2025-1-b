import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormInstrumentoComponent } from './form-instrumento.component';

describe('FormInstrumentoComponent', () => {
  let component: FormInstrumentoComponent;
  let fixture: ComponentFixture<FormInstrumentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormInstrumentoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormInstrumentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

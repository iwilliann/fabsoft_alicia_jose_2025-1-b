import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEmprestimoComponent } from './form-emprestimo.component';

describe('FormEmprestimoComponent', () => {
  let component: FormEmprestimoComponent;
  let fixture: ComponentFixture<FormEmprestimoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormEmprestimoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormEmprestimoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilClienteListComponent } from './perfil-cliente-list.component';

describe('PerfilClienteListComponent', () => {
  let component: PerfilClienteListComponent;
  let fixture: ComponentFixture<PerfilClienteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilClienteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilClienteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

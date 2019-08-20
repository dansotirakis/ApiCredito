import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilFindComponent } from './perfil-find.component';

describe('PerfilFindComponent', () => {
  let component: PerfilFindComponent;
  let fixture: ComponentFixture<PerfilFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

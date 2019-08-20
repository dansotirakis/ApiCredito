import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilDetailComponent } from './perfil-detail.component';

describe('PerfilDetailComponent', () => {
  let component: PerfilDetailComponent;
  let fixture: ComponentFixture<PerfilDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

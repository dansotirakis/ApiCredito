import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropostaFindComponent } from './proposta-find.component';

describe('PropostaFindComponent', () => {
  let component: PropostaFindComponent;
  let fixture: ComponentFixture<PropostaFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropostaFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropostaFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

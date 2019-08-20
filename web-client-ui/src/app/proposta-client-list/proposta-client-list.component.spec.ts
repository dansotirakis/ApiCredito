import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropostaClientListComponent } from './proposta-client-list.component';

describe('PropostaClientListComponent', () => {
  let component: PropostaClientListComponent;
  let fixture: ComponentFixture<PropostaClientListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropostaClientListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropostaClientListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

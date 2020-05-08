import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TbarComponent } from './tbar.component';

describe('TbarComponent', () => {
  let component: TbarComponent;
  let fixture: ComponentFixture<TbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularJavaComponent } from './angular-java.component';

describe('AngularJavaComponent', () => {
  let component: AngularJavaComponent;
  let fixture: ComponentFixture<AngularJavaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AngularJavaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularJavaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

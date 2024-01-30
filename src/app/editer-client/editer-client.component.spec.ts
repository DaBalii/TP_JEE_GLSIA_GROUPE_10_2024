import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerClientComponent } from './editer-client.component';

describe('EditerClientComponent', () => {
  let component: EditerClientComponent;
  let fixture: ComponentFixture<EditerClientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditerClientComponent]
    });
    fixture = TestBed.createComponent(EditerClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

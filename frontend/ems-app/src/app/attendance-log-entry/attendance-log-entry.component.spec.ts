import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttendanceLogEntryComponent } from './attendance-log-entry.component';

describe('AttendanceLogEntryComponent', () => {
  let component: AttendanceLogEntryComponent;
  let fixture: ComponentFixture<AttendanceLogEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttendanceLogEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttendanceLogEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

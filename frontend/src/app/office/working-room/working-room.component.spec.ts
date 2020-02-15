import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkingRoomComponent } from './working-room.component';

describe('WorkingRoomComponent', () => {
  let component: WorkingRoomComponent;
  let fixture: ComponentFixture<WorkingRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkingRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkingRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

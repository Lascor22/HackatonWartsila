import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkingRoomAntresolComponent } from './working-room-antresol.component';

describe('WorkingRoomAntresolComponent', () => {
  let component: WorkingRoomAntresolComponent;
  let fixture: ComponentFixture<WorkingRoomAntresolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkingRoomAntresolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkingRoomAntresolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

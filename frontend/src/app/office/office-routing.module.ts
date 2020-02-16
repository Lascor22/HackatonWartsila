import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FirstFloorComponent} from './first-floor/first-floor.component';
import {ThirdFloorComponent} from './third-floor/third-floor.component';
import {ModalComponent} from './modal/modal.component';
import {WorkingRoomComponent} from './working-room/working-room.component';
import {WorkingRoomAntresolComponent} from './working-room-antresol/working-room-antresol.component';

const officeRoutes: Routes = [
  { path: 'office/floor/1/**', component: FirstFloorComponent},
  { path: 'office/floor/1', component: FirstFloorComponent},
  { path: 'office/floor/3', component: ThirdFloorComponent},
  { path: 'office/floor/1/room/:room', component: FirstFloorComponent},
  { path: 'office/floor/3/room/:room', component: ThirdFloorComponent},
  { path: 'office/floor/3/room/:room/antresol', component: ThirdFloorComponent},
  { path: '', component: FirstFloorComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      officeRoutes
    )
  ]
})
export class OfficeRoutingModule { }

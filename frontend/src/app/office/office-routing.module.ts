import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FirstFloorComponent} from './first-floor/first-floor.component';
import {ThirdFloorComponent} from './third-floor/third-floor.component';

const officeRoutes: Routes = [
  { path: 'office/floor/1', component: FirstFloorComponent},
  { path: 'office/floor/3', component: ThirdFloorComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      officeRoutes
    )
  ]
})
export class OfficeRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {AppComponent} from './app.component';
import { FirstFloorComponent } from './office/first-floor/first-floor.component';
import {HttpClientModule} from '@angular/common/http';
import {PopupModule} from '@progress/kendo-angular-popup';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ModalComponent } from './office/modal/modal.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ThirdFloorComponent } from './office/third-floor/third-floor.component';
import { WorkingRoomComponent } from './office/working-room/working-room.component';
import { WorkingRoomAntresolComponent } from './office/working-room-antresol/working-room-antresol.component';
import {OfficeRoutingModule} from './office/office-routing.module';
import {RouterModule} from '@angular/router';
import { TopMenuComponent } from './office/top-menu/top-menu.component';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    FirstFloorComponent,
    ModalComponent,
    ThirdFloorComponent,
    WorkingRoomComponent,
    WorkingRoomAntresolComponent,
    TopMenuComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    PopupModule,
    NgbModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    OfficeRoutingModule,
    RouterModule
  ],
  entryComponents: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

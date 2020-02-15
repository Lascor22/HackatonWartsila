import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {AppComponent} from './app.component';
import { FirstFloorComponent } from './office/first-floor/first-floor.component';
import {HttpClientModule} from '@angular/common/http';
import {PopupModule} from '@progress/kendo-angular-popup';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ModalComponent } from './office/modal/modal.component';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import { ThirdFloorComponent } from './office/third-floor/third-floor.component';
import { WorkingRoomComponent } from './office/working-room/working-room.component';
import { WorkingRoomAntresolComponent } from './office/working-room-antresol/working-room-antresol.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstFloorComponent,
    ModalComponent,
    ThirdFloorComponent,
    WorkingRoomComponent,
    WorkingRoomAntresolComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    PopupModule,
    NgbModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule
  ],
  entryComponents: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

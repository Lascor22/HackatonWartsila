import {Component, OnInit} from '@angular/core';
import {DataService} from '../service/data.service';
import {WorkingRoomDTO} from '../dto/DTOs';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {WorkingRoomComponent} from '../working-room/working-room.component';
import { Location } from '@angular/common'
import {WorkingRoomAntresolComponent} from '../working-room-antresol/working-room-antresol.component';
import {ModalComponent} from '../modal/modal.component';

@Component({
  selector: 'app-first-floor',
  templateUrl: './first-floor.component.html',
  styleUrls: ['./first-floor.component.css']
})
export class FirstFloorComponent implements OnInit {
  selectedRoom: WorkingRoomDTO;
  private popupConfig: MatDialogConfig;

  constructor(private dataService: DataService,
              private matDialog: MatDialog,
              private location: Location) {
  }

  configurePopupWindow() {
    this.popupConfig = new MatDialogConfig();
    this.popupConfig.disableClose = true;
    this.popupConfig.id = 'modal-component';
    this.popupConfig.height = '660px';
    this.popupConfig.width = '900px';
    this.popupConfig.maxHeight = '660px';
  }

  ngOnInit(): void {
    console.log('first floor onInit');
    if (this.location.path().match(new RegExp('office/floor/1/room/*'))) {
      console.log('if');
      this.configurePopupWindow();
      const modalDialog = this.matDialog.open(ModalComponent, this.popupConfig);
    }
  }

  openModal() {
    this.location.go(this.location.path() + '/room/123');
    this.configurePopupWindow();
    const modalDialog = this.matDialog.open(ModalComponent, this.popupConfig);
  }

  onWorkingRoomClick(event: MouseEvent) {
    const roomNumber: number = +(event.target as Element).innerHTML;
    console.log(roomNumber);
    this.dataService.getWorkingRoom(roomNumber).subscribe(response => {
      console.log(response);
    });
    this.openModal();
  }

}

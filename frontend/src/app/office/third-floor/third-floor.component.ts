import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {DataService} from '../service/data.service';
import {Location} from '@angular/common';
import {ModalComponent} from '../modal/modal.component';

@Component({
  selector: 'app-third-floor',
  templateUrl: './third-floor.component.html',
  styleUrls: ['./third-floor.component.css']
})
export class ThirdFloorComponent implements OnInit {
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
    this.popupConfig.id = 'thirdfloor';
  }

  ngOnInit(): void {
    console.log('third floor onInit');
    if (this.location.path().match(new RegExp('office/floor/3/room/*'))) {
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
    // const roomNumber: number = +(event.target as Element).innerHTML;
    // this.dataService.getWorkingRoom(roomNumber).subscribe(response => {
    //   console.log(response);
    // });
    this.openModal();
  }

}

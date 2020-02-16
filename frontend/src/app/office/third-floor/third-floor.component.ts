import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {DataService} from '../service/data.service';
import {Location} from '@angular/common';
import {ModalComponent} from '../modal/modal.component';
import {EmployeeDTO} from '../dto/DTOs';

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

  openModalWithData(data, roomNumber) {
    this.location.go(this.location.path() + '/room/' + roomNumber);
    this.configurePopupWindow();
    this.popupConfig.data = data;
    const modalDialog = this.matDialog.open(ModalComponent, this.popupConfig);
  }

  // openModal() {
  //   this.location.go(this.location.path() + '/room/123');
  //   this.configurePopupWindow();
  //   const modalDialog = this.matDialog.open(ModalComponent, this.popupConfig);
  // }

  onWorkingRoomClick(event: MouseEvent) {
    const roomNumber: number = +(event.target as Element).innerHTML;
    let responseData: EmployeeDTO[];
    console.log(roomNumber);
    this.dataService.getEmployeesFromWorkingRoom(roomNumber).subscribe(response => {
      console.log('response:');
      console.log(response);
      responseData = response;
      this.openModalWithData(responseData, roomNumber);
    });
  }

}

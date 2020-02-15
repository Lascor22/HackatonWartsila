import {Component, Input, OnInit} from '@angular/core';
import {DataService} from '../service/data.service';
import {WorkingRoomDTO} from '../dto/DTOs';
import {ModalModule} from 'ngb-modal';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {ModalComponent} from '../modal/modal.component';
import {WorkingRoomComponent} from '../working-room/working-room.component';

@Component({
  selector: 'app-first-floor',
  templateUrl: './first-floor.component.html'
})
export class FirstFloorComponent implements OnInit {
  selectedRoom: WorkingRoomDTO;

  constructor(private dataService: DataService,
              private matDialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  openModal() {
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = 'modal-component';
    dialogConfig.height = '350px';
    dialogConfig.width = '600px';
    // https://material.angular.io/components/dialog/overview
    const modalDialog = this.matDialog.open(WorkingRoomComponent, dialogConfig);
  }

  onWorkingRoomClick(event: MouseEvent) {
    // const roomNumber: number = +(event.target as Element).innerHTML;
    // this.dataService.getWorkingRoom(roomNumber).subscribe(response => {
    //   console.log(response);
    // });
    this.openModal();
  }

}

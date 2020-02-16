import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogConfig, MatDialogRef} from '@angular/material/dialog';
import {Location} from '@angular/common';
import {DataService} from '../service/data.service';
import {EmployeeDTO, EventDTO} from '../dto/DTOs';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {EventCreateComponent} from '../event-create/event-create.component';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  public isAntresol = false;
  public isEmployeesSelected = true;
  public roomNumber: number;
  public antresolNumber: number;
  public activeRoomNumber;
  private popupConfig: MatDialogConfig;

  public employees: EmployeeDTO[];
  public events: EventDTO[];

  constructor(public dialogRef: MatDialogRef<ModalComponent>,
              private location: Location,
              @Inject(MAT_DIALOG_DATA) public data,
              private dataService: DataService,
              private matDialog: MatDialog) {
    // this.employees = data;
    this.roomNumber = +this.location.path().substr(this.location.path().lastIndexOf('/') + 1);
    this.antresolNumber = +(this.roomNumber.toString() + '2');
    this.activeRoomNumber = this.roomNumber;
    this.reloadData();
  }

  configurePopupWindow() {
    this.popupConfig = new MatDialogConfig();
    this.popupConfig.disableClose = true;
    this.popupConfig.id = 'modal-component';
    this.popupConfig.height = '400px';
    this.popupConfig.width = '500px';
    this.popupConfig.maxHeight = '400px';
    this.popupConfig.id = 'modalwindow';
  }

  openEventCreateModal() {
    this.configurePopupWindow();
    this.popupConfig.data = this.roomNumber;
    const modalDialog = this.matDialog.open(EventCreateComponent, this.popupConfig);
  }

  public toggleIsAntresol() {
    this.isAntresol = !this.isAntresol;
    if (this.isAntresol) {
      this.activeRoomNumber = this.antresolNumber;
    } else {
      this.activeRoomNumber = this.roomNumber;
    }
    this.reloadData();
  }

  public toggleIsEmployeesSelected() {
    console.log('toggle');
    this.isEmployeesSelected = !this.isEmployeesSelected;
    console.log(this.isEmployeesSelected);
    this.reloadData();
  }

  reloadEmployees() {
    this.dataService.getEmployeesFromWorkingRoom(this.activeRoomNumber).subscribe(response => {
      this.employees = response;
      console.log('response: ');
      console.log(response);
      console.log('employees:');
      console.log(this.employees);
    });
  }

  reloadEvents() {
    console.log('roomNumber:');
    console.log(this.roomNumber);
    this.dataService.getEventsFromWorkingRoom(this.activeRoomNumber).subscribe(response => {
      this.events = response;
      console.log('events:');
      console.log(this.events);
    });
  }

  addEvent() {

  }

  reloadData() {
    this.reloadEmployees();
    this.reloadEvents();
  }

  goBack() {
    const back = this.location.path().substr(0, this.location.path().lastIndexOf('/'));
    this.location.go(back);
  }

  fixUrl() {
    this.goBack();
    this.goBack();
  }

  closeModal() {
    this.fixUrl();
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log('modal onInit');
  }

}

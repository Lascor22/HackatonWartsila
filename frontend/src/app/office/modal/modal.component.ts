import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Location} from '@angular/common';
import {DataService} from '../service/data.service';
import {EmployeeDTO} from '../dto/DTOs';
import {Data} from '@angular/router';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  public isAntresol = false;
  public isEmployeesSelected = true;
  public roomNumber: number;

  public employees: EmployeeDTO[];
  public events: string[] = ['Blagoy\'s birthday', 'Blagoy\'s birthday', 'Blagoy\'s birthday', 'Blagoy\'s birthday', ];

  constructor(public dialogRef: MatDialogRef<ModalComponent>,
              private location: Location,
              @Inject(MAT_DIALOG_DATA) public data,
              private dataService: DataService) {
    this.employees = data;
    this.roomNumber = +this.location.path().substr(this.location.path().lastIndexOf('/') + 1);
  }

  public toggleIsAntresol() {
    this.isAntresol = !this.isAntresol;
  }

  public toggleIsEmployeesSelected() {
    console.log('toggle');
    this.isEmployeesSelected = !this.isEmployeesSelected;
    console.log(this.isEmployeesSelected);
  }

  reloadData() {

  }

  actionFunction() {
    alert('You have logged out.');
    this.closeModal();
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
    console.log('modal oninit');
  }

}

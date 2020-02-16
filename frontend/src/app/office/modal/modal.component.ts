import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {Location} from '@angular/common';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  public isAntresol = false;
  public isEmployeesSelected = true;
  public employees: string[] = ['Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov',
    'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov',
    'Blagoy Dimitrov', 'Blagoy Dimitrov'];

  public events: string[] = ['Blagoy\'s birthday', 'Blagoy\'s birthday', 'Blagoy\'s birthday', 'Blagoy\'s birthday', ];

  constructor(public dialogRef: MatDialogRef<ModalComponent>,
              private location: Location) { }

  public toggleIsAntresol() {
    this.isAntresol = !this.isAntresol;
  }

  public toggleIsEmployeesSelected() {
    console.log('toggle');
    this.isEmployeesSelected = !this.isEmployeesSelected;
    console.log(this.isEmployeesSelected);
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

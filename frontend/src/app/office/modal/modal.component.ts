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
  public employees: string[] = ['Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov', 'Blagoy Dimitrov'];
  constructor(public dialogRef: MatDialogRef<ModalComponent>,
              private location: Location) { }

  public toggleIsAntresol() {
    this.isAntresol = !this.isAntresol;
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

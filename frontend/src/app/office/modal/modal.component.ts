import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ModalComponent>) { }

  actionFunction() {
    alert('You have logged out.');
    this.closeModal();
  }

  closeModal() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

}

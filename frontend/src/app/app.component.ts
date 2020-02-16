import {Component, Input} from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  clickX: number;
  clickY: number;

  constructor(private matDialog: MatDialog) {
  }
}

import {Component, Input} from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {Location} from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  constructor(private matDialog: MatDialog) {
  }
}

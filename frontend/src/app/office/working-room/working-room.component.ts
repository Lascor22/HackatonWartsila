import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-working-room',
  templateUrl: './working-room.component.html',
  styleUrls: ['./working-room.component.css']
})
export class WorkingRoomComponent implements OnInit {
  constructor(public dialogRef: MatDialogRef<WorkingRoomComponent>) { }

  ngOnInit(): void {
  }

}

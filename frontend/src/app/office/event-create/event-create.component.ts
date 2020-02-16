import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {
  public eventForm: FormGroup;

  constructor(public dialogRef: MatDialogRef<EventCreateComponent>) {
    this.eventForm = new FormGroup({
      name: new FormControl(''),
      description: new FormControl(''),
      creator: new FormControl('')
    });
  }

  ngOnInit(): void {
  }

  createEvent() {
      console.log(this.eventForm.get('name').value);
      console.log(this.eventForm.get('description').value);
      console.log(this.eventForm.get('creator').value);
  }
}

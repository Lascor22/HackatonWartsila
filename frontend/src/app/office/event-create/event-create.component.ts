import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormControl, FormGroup} from '@angular/forms';
import {DataService} from '../service/data.service';
import {EventService} from '../service/event.service';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {
  public eventForm: FormGroup;
  public roomNumber: number;
  constructor(public dialogRef: MatDialogRef<EventCreateComponent>,
              @Inject(MAT_DIALOG_DATA) public data,
              private dataService: DataService,
              private eventService: EventService) {
    this.eventForm = new FormGroup({
      name: new FormControl(''),
      description: new FormControl(''),
      creator: new FormControl('')
    });

    this.roomNumber = data;
  }

  ngOnInit(): void {
  }


  createEvent() {
    console.log(this.data);
    const name = this.eventForm.get('name').value;
    const description = this.eventForm.get('description').value;
    const creator = this.eventForm.get('creator').value;

    this.eventService.createEvent(this.data, creator, name, description).subscribe(response => {
      this.dialogRef.close();
    });

      // console.log(this.eventForm.get('name').value);
      // console.log(this.eventForm.get('description').value);
      // console.log(this.eventForm.get('creator').value);
  }
}

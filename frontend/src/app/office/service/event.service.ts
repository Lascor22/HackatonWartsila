import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EventForm, WorkingRoomDTO} from '../dto/DTOs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }

  public createEvent(roomNumber: number, creator: string, name: string, description: string): Observable<any> {
    console.log(roomNumber);
    return this.http.post('http://localhost:8080/api/0/event', new EventForm(roomNumber, creator, name, description));
  }
}

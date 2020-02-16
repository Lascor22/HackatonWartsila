import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {WorkingRoomDTO} from '../dto/DTOs';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {
  }

  public getWorkingRoom(roomNumber: number): Observable<any> {
    return this.httpClient.get('http://localhost:8080/api/0/workroom/number/105');
    // return this.httpClient.get<WorkingRoomDTO>('http://localhost:8080/api/0/workroom/number/' + roomNumber);
  }
}

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {
  }

  public getWorkingRoom(roomNumber: number) {
    return this.httpClient.get('');
  }
}

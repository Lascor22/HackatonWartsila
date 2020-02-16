import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.css']
})
export class TopMenuComponent implements OnInit {
  public isFirstFloor: boolean;

  constructor(private location: Location) {
    if (this.location.path() === '') {
      this.location.go('/office/floor/1');
    }
    this.isFirstFloor = this.location.path().includes('/floor/1') || this.location.path() === '';
  }

  toggleIsFirstFloor() {
    this.isFirstFloor = !this.isFirstFloor;
  }

  ngOnInit(): void {
  }

}

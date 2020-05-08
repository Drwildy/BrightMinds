import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tbar',
  templateUrl: './tbar.component.html',
  styleUrls: ['./tbar.component.css']
})
export class TbarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout():void{
    sessionStorage.clear();
    this.router.navigate[('/login')];
  }

}
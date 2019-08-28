import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isCandCollapsed=false;
  isAnswerCollapsed=false;
  isQuestCollapsed=false;
  isJobCollapsed=false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }
  candcollapse() {
    if (this.isCandCollapsed === false) {
      this.isCandCollapsed = true;
    } else { this.isCandCollapsed = false; }
  }
  questcollapse() {
    if (this.isQuestCollapsed === false) {
      this.isQuestCollapsed = true;
    } else { this.isQuestCollapsed = false; }
  }
  answercollapse() {
    if (this.isAnswerCollapsed === false) {
      this.isAnswerCollapsed = true;
    } else { this.isAnswerCollapsed = false; }
  }
  jobcollapse() {
    if (this.isJobCollapsed === false) {
      this.isJobCollapsed = true;
    } else { this.isJobCollapsed = false; }
  }
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}

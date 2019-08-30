import { UserDTO } from 'src/dto/userdto';
import { OnInit, Component } from '@angular/core';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
    selector: 'app-user-dashboard',
    templateUrl: './user-dashboard.component.html',
    styleUrls: ['./user-dashboard.component.css']
  })
  export class UserDashboardComponent implements OnInit {
  
    user: UserDTO;
  
    constructor() { }
  
    ngOnInit() {
      this.user = JSON.parse(localStorage.getItem('currentUser'));
    }
  
  }
  
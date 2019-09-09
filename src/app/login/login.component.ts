import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/service/login.service';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  state = 'default';
  logstate = 'default';
  signstate = 'default';

  ext() {
    this.state = 'default';
  }

  logst(){
    this.state = 'logstate';
  }

  regst(){
    this.state = 'signstate';
  }
  constructor(private service: LoginService, private router: Router ) { }


  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);
    this.service.login(this.loginDTO).subscribe((response: any) => {
      localStorage.setItem('currentUser', JSON.stringify({ authorities: response.id_token }));

      this.service.getUserLogged(this.loginDTO.username).subscribe((response: UserDTO) => {
        localStorage.setItem('currentUserData', JSON.stringify(response));

        if (response.authorities.includes('ROLE_ADMIN')) {
          this.router.navigate(['/admin-dashboard']);
        } else {
          this.router.navigate(['/user-dashboard']);
        }
      });
    });
  }
}
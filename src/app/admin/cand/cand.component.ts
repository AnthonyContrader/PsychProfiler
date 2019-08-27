import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { CandService } from 'src/service/cand.service';
import { UserDTO } from 'src/dto/userdto';
import { CandDTO } from 'src/dto/canddto';

@Component({
  selector: 'app-cand',
  templateUrl: './cand.component.html',
  styleUrls: ['./cand.component.css']
})
export class CandComponent implements OnInit {

  cands: CandDTO[];
  candtoinsert: CandDTO = new CandDTO();
  users: UserDTO[];

  constructor(private service: CandService,  private uService: UserService) { }

  ngOnInit() {
    this.getUser();
    this.getCand();
  }

  getCand() {
    this.service.getAll().subscribe(cands => this.cands = cands);
  }
  getUser() {
    this.uService.getAll().subscribe(user => this.users = user);
  }

  delete(cand: CandDTO) {
    this.service.delete(cand.id).subscribe(() => this.getCand());
  }

  update(cand: CandDTO) {
    this.service.update(cand).subscribe(() => this.getCand());
  }

  insert(cand: CandDTO) {
    this.service.insert(cand).subscribe(() => this.getCand());
  }

  clear(){
    this.candtoinsert = new CandDTO();
  }
}

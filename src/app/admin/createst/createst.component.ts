import { Component, OnInit } from '@angular/core';
import {QuestService} from 'src/service/quest.service';
import{QuestDTO} from 'src/dto/questdto'
import { FormGroup, FormControl, NgForm } from '@angular/forms';
@Component({
  selector: 'app-createst',
  templateUrl: './createst.component.html',
  styleUrls: ['./createst.component.css']
})
export class CreatestComponent implements OnInit {
  ctests: QuestDTO[];
  tests: QuestDTO[];
  teststoinsert: QuestDTO = new QuestDTO();
  constructor(private cService: QuestService ) { }
  //form: FormGroup;
  ngOnInit() {
  this.getTest();
  }

  getTest(){
    this.cService.getAll().subscribe(tests => this.tests = tests);
  
  
}



  delete(tests: QuestDTO) {
    this.cService.delete(tests.id).subscribe(() => this.getTest());
  }

  update(tests: QuestDTO) {
    this.cService.update(tests).subscribe(() => this.getTest());
  }

  create(t: NgForm){
   // console.log(t.value.arg);
   // console.log(t.value.nquest);
    this.cService.create(t.value.arg, t.value.nquest).subscribe(test => this.ctests= test);
  }

  insert(tests: QuestDTO) {
    this.cService.insert(tests).subscribe(() => this.getTest());
  }

  clear(){
    this.teststoinsert = new QuestDTO();
  }
}
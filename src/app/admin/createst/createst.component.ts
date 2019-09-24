import { Component, OnInit } from '@angular/core';
import {QuestService} from 'src/service/quest.service';
import{QuestDTO} from 'src/dto/questdto';
import {CandService} from 'src/service/cand.service';
import{AnswerService} from 'src/service/answer.service';

import { FormGroup, FormControl, NgForm } from '@angular/forms';
import { getAllLifecycleHooks } from '@angular/compiler/src/lifecycle_reflector';
import { CandDTO } from 'src/dto/canddto';
import { AnswerDTO } from 'src/dto/answerdto';
import { createEmptyStateSnapshot } from '@angular/router/src/router_state';
@Component({
  selector: 'app-createst',
  templateUrl: './createst.component.html',
  styleUrls: ['./createst.component.css']
})
export class CreatestComponent implements OnInit {
  cand:CandDTO[];
  ctests: QuestDTO[];
  tests: QuestDTO[];
  answer: AnswerDTO[]
  teststoinsert: QuestDTO = new QuestDTO();
  quest: QuestDTO;
  constructor(private cService: QuestService, private candService: CandService, private ansService: AnswerService) { }
  //form: FormGroup;
  ngOnInit() {
  this.getTest();
  //this.getcands();

  }

  getTest(){
    this.cService.getAll().subscribe(tests => this.tests = tests);
  
  
}
 getcands(){
   this.candService.getAll().subscribe(cand => this.cand = cand);
 }




  delete(tests: QuestDTO) {
    this.cService.delete(tests.id).subscribe(() => this.getTest());
  }

  update(tests: QuestDTO) {
    this.cService.update(tests).subscribe(() => this.getTest());
  }

 /* create(t: NgForm){

   let i = 0; 
   let ans : AnswerDTO;
   for(  let q of this.tests)
    {
      if (q.args.includes(t.value.arg))
      {   
         ans = new AnswerDTO();
         ans.cand= t.value.getcands;
         ans.answer_questId= q.id;
         ans.ans=0;
         this.ansService.insert(ans).subscribe(() => this.getTest());
          i++;
          if(i = t.value.nquest)
          break;
      }
    }
  
  }*/
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
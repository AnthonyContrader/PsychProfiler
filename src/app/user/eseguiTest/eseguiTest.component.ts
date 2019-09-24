import { Component, OnInit } from '@angular/core';
import { AnswerService } from 'src/service/answer.service';
import { AnswerDTO } from 'src/dto/answerdto';
import {QuestDTO} from 'src/dto/questdto';
import { QuestService } from 'src/service/quest.service';
import {UserDTO} from 'src/dto/userdto';

@Component({
    selector: 'app-eseguiTest',
    templateUrl: './eseguiTest.component.html',
    styleUrls: ['./eseguiTest.component.css']
  })
  export class EseguiTestComponent implements OnInit 
  { 
    answer: AnswerDTO[];
    question : QuestDTO[];
    user: UserDTO;
    constructor(private service: AnswerService, private QService: QuestService) {
        
     }
    ngOnInit() {
        this.user = JSON.parse(localStorage.getItem('currentUser'));
        
        this.service.getAll().subscribe( answer => this.answer = answer);
    }



    /*esegui(){
       

        for(let ans of this.answer)
        {
            if(this.user)
        }
    }*/

  }



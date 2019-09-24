import { Component, OnInit } from '@angular/core';
import { AnswerService } from 'src/service/answer.service';
import { AnswerDTO } from 'src/dto/answerdto';
import { CandDTO } from 'src/dto/canddto';
import { QuestDTO } from 'src/dto/questdto';
import { CandService } from 'src/service/cand.service';
import { QuestService } from 'src/service/quest.service';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {

  answers: AnswerDTO[];
  answertoinsert: AnswerDTO = new AnswerDTO();
  cands: CandDTO[];
  quests: QuestDTO[];
  constructor(private service: AnswerService, private cService: CandService, private qService: QuestService) { }

  ngOnInit() {
    this.getCand();
    this.getQuest();
    this.getAnswer();
  }

  getAnswer() {
    this.service.getAll().subscribe(answers => this.answers = answers);
  }
  getCand() {
    this.cService.getAll().subscribe(cands => this.cands = cands);
  }
  getQuest() {
    this.qService.getAll().subscribe(quests => this.quests = quests);
  }
  delete(answer: AnswerDTO) {
    this.service.delete(answer.id).subscribe(() => this.getAnswer());
  }

  update(answer: AnswerDTO) {
    this.service.update(answer).subscribe(() => this.getAnswer());
  }

  insert(answer: AnswerDTO) {
    this.service.insert(answer).subscribe(() => this.getAnswer());
  }

  clear(){
    this.answertoinsert = new AnswerDTO();
  }
}
import { Component, OnInit } from '@angular/core';
import { QuestService } from 'src/service/quest.service';
import { QuestDTO } from 'src/dto/questdto';

@Component({
  selector: 'app-quest',
  templateUrl: './quest.component.html',
  styleUrls: ['./quest.component.css']
})
export class QuestComponent implements OnInit {

  quests: QuestDTO[];
  questtoinsert: QuestDTO = new QuestDTO();

  constructor(private service: QuestService) { }

  ngOnInit() {
    this.getQuest();
  }

  getQuest() {
    this.service.getAll().subscribe(quests => this.quests = quests);
  }
  delete(quest: QuestDTO) {
    this.service.delete(quest.id).subscribe(() => this.getQuest());
  }

  update(quest: QuestDTO) {
    this.service.update(quest).subscribe(() => this.getQuest());
  }

  insert(quest: QuestDTO) {
    this.service.insert(quest).subscribe(() => this.getQuest());
  }

  clear(){
    this.questtoinsert = new QuestDTO();
  }
}
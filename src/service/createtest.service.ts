import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestDTO } from 'src/dto/questdto';


@Injectable({
  providedIn: 'root'
})
export class CreatetestService extends AbstractService<QuestDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'createst';
  }

}
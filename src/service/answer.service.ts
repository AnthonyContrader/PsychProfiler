import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AnswerDTO } from 'src/dto/answerdto';


@Injectable({
  providedIn: 'root'
})
export class AnswerService extends AbstractService<AnswerDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'answer';
    this.micro = 'micro2';
  }

}
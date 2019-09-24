import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestDTO } from 'src/dto/questdto';


@Injectable({
  providedIn: 'root'
})
export class QuestService extends AbstractService<QuestDTO>{
 
  constructor(http: HttpClient) {
    super(http);
    this.type = 'quest';
    this.micro= 'micro2';
  }

  create(arg: string, num: number) : Observable<QuestDTO[]>{
    return this.http.get<QuestDTO[]>('http://localhost:' + this.port + '/' + this.type + '/create?arg=' + arg+'&nquest='+num);
  }


}
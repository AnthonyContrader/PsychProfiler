import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobDTO } from 'src/dto/jobdto';


@Injectable({
  providedIn: 'root'
})
export class JobService extends AbstractService<JobDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'job';
    this.micro= 'micro1';
  }

}

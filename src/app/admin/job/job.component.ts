import { Component, OnInit } from '@angular/core';
import { JobService } from 'src/service/job.service';
import { JobDTO } from 'src/dto/jobdto';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {

  jobs: JobDTO[];
  jobtoinsert: JobDTO = new JobDTO();

  constructor(private service: JobService) { }

  ngOnInit() {
    this.getJob();
  }

  getJob() {
    this.service.getAll().subscribe(jobs => this.jobs = jobs);
  }

  delete(job: JobDTO) {
    this.service.delete(job.id).subscribe(() => this.getJob());
  }

  update(job: JobDTO) {
    this.service.update(job).subscribe(() => this.getJob());
  }

  insert(job: JobDTO) {
    this.service.insert(job).subscribe(() => this.getJob());
  }

  clear(){
    this.jobtoinsert = new JobDTO();
  }
}
export interface IJob {
  id?: number;
  role?: string;
  description?: string;
}

export class Job implements IJob {
  constructor(public id?: number, public role?: string, public description?: string) {}
}

export interface ICand {
  id?: number;
  name?: string;
  surname?: string;
  age?: number;
  experience?: string;
  user?: string;
}

export class Cand implements ICand {
  constructor(
    public id?: number,
    public name?: string,
    public surname?: string,
    public age?: number,
    public experience?: string,
    public user?: string
  ) {}
}

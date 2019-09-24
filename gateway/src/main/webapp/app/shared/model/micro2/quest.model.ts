export interface IQuest {
  id?: number;
  args?: string;
  quest?: string;
  ans1?: string;
  ans2?: string;
  ans3?: string;
  ans4?: string;
}

export class Quest implements IQuest {
  constructor(
    public id?: number,
    public args?: string,
    public quest?: string,
    public ans1?: string,
    public ans2?: string,
    public ans3?: string,
    public ans4?: string
  ) {}
}

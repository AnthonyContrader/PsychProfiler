export interface IAnswer {
  id?: number;
  cand?: string;
  ans?: number;
  answer_questQuest?: string;
  answer_questId?: number;
}

export class Answer implements IAnswer {
  constructor(
    public id?: number,
    public cand?: string,
    public ans?: number,
    public answer_questQuest?: string,
    public answer_questId?: number
  ) {}
}

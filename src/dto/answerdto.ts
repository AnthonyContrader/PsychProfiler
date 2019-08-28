import { QuestDTO } from './questdto';
import { CandDTO } from './canddto';

export class AnswerDTO{

    id: number;

    cand: CandDTO;
    
    quest: QuestDTO;
    
	ans: number;
}
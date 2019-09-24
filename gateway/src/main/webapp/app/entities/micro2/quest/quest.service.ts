import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IQuest } from 'app/shared/model/micro2/quest.model';

type EntityResponseType = HttpResponse<IQuest>;
type EntityArrayResponseType = HttpResponse<IQuest[]>;

@Injectable({ providedIn: 'root' })
export class QuestService {
  public resourceUrl = SERVER_API_URL + 'services/micro2/api/quests';

  constructor(protected http: HttpClient) {}

  create(quest: IQuest): Observable<EntityResponseType> {
    return this.http.post<IQuest>(this.resourceUrl, quest, { observe: 'response' });
  }

  update(quest: IQuest): Observable<EntityResponseType> {
    return this.http.put<IQuest>(this.resourceUrl, quest, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IQuest>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IQuest[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}

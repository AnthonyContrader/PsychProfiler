import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICand } from 'app/shared/model/micro1/cand.model';

type EntityResponseType = HttpResponse<ICand>;
type EntityArrayResponseType = HttpResponse<ICand[]>;

@Injectable({ providedIn: 'root' })
export class CandService {
  public resourceUrl = SERVER_API_URL + 'services/micro1/api/cands';

  constructor(protected http: HttpClient) {}

  create(cand: ICand): Observable<EntityResponseType> {
    return this.http.post<ICand>(this.resourceUrl, cand, { observe: 'response' });
  }

  update(cand: ICand): Observable<EntityResponseType> {
    return this.http.put<ICand>(this.resourceUrl, cand, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICand>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICand[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}

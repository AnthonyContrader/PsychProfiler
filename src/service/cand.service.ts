import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CandDTO } from 'src/dto/canddto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class CandService extends AbstractService<CandDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'cand';
    this.micro= 'micro1'
  }
  getAllUser(user: UserDTO): Observable<CandDTO[]>{
   
        return this.http.post<CandDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getAllUser', user);
  }


}

import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

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
export class UserService extends AbstractService<UserDTO>{

  constructor( http: HttpClient) {
    super(http);
    this.type = 'user';
    this.port='8080';
    
   }


  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

  getAll(): Observable<UserDTO[]>{
    return this.http.get<UserDTO[]>('http://localhost:8080/api/'+this.type + 's', {
      headers: {
          Authorization: this.auth()
      }
    });
  }

  read(id: number): Observable<UserDTO> {
    return this.http.get<UserDTO>('http://localhost:'+ this.port +'/api/'+ this.type + 's/' + id, {
        headers: {
            Authorization: this.auth()
        }
      } );
}

delete(id: number): Observable<any> {
    return this.http.delete('http://localhost:'+ this.port +'/api/'+ this.type + 's/' + id, {
        headers: {
            Authorization: this.auth()
        }
      });
}

insert(dto: UserDTO): Observable<any> {
  return this.http.post('http://localhost:'+ this.port +'/api/'+ this.type + 's', dto, {
      headers: {
          Authorization: this.auth()
      }
    });
}

update(dto: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>('http://localhost:'+ this.port +'/api/'+ this.type + 's', dto, {
        headers: {
            Authorization: this.auth()
        }
      });

}

}

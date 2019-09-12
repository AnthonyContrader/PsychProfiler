import {Injectable} from '@angular/core';
import { HttpClient, HttpParams , HttpResponse, HttpClientModule} from '@angular/common/http';
import { Observable, of, } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { UserDTO } from 'src/dto/userdto';
import { LoginDTO } from 'src/dto/logindto';
import {RegisterDTO} from 'src/dto/registerdto';

@Injectable({
    providedIn: 'root'
})

export class LoginService{
    user: UserDTO;
    
    constructor(private http: HttpClient){}

    private handleError<T>(operation = 'operation', result?: T){
        return (error: any): Observable<T> =>{
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    auth(){
        this.user=JSON.parse(localStorage.getItem('currentUser'));
        if(this.user){
            return 'Bearer ' +this.user.authorities;
        }
        else
        {
            return'';
        }

    }
    register(registerdto: RegisterDTO){
        return this.http.post('http://localhost:8080/api/register',registerdto);
    }
    login(logindto: LoginDTO){
    return this.http.post('http://localhost:8080/api/authenticate', logindto);
    }
    getUserLogged(username: string){
        return this.http.get('http://localhost:8080/api/users/'+ username,
         {headers:{Authorization: this.auth()
    }});
}



}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from '../model/user';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userActualizar = new Subject<User[]>();

  private url: string = "http://localhost:8080/user"
  constructor(private http: HttpClient) { }

  listar(){
   return this.http.get<User[]>(this.url);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/delete/${id}`)
  }

  editar (user: User){
    return this.http.put(this.url, user);
  }


  registrar (user: User){
    return this.http.post(this.url, user);
  }
}

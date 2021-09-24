import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Rol } from '../model/rol';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private url : string = 'http://localhost:8080/rol'

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Rol[]>(this.url);
   }
}

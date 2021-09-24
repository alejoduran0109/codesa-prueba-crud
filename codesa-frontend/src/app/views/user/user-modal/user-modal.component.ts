import { Component, Inject, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserService } from '../../../service/user.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Rol } from '../../../model/rol';
import { RolService } from '../../../service/rol.service';

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent implements OnInit {

  user!: User;
  rol!: Rol[];
  
  someName = [
    {name: "John",id: "1"},
    {name: "robert", id: "2"}
    ];

  constructor(
    private dialogRef: MatDialogRef<UserModalComponent>,
    private rolService: RolService,
    private userService: UserService,
    @Inject(MAT_DIALOG_DATA) private data: User) {
    }

  ngOnInit(): void {
    this.rolService.listar().subscribe(data =>{
      this.rol = data;
    })
    this.user = new User();
    this.user.idUsuario = this.data.idUsuario ;
    this.user.nombre = this.data.nombre;
    this.user.activo = this.data.activo;
    this.user.rol = this.data.rol;
    console.log(this.user.rol);



    }

    aceptar(){
      if(this.user != null && this.user.idUsuario > 0){
        this.userService.editar(this.user).subscribe(()=>{
          return this.userService.listar().subscribe(data =>{
            this.userService.userActualizar.next(data);
          })
        })
      }else{
        this.userService.registrar(this.user).subscribe(()=>{
          this.userService.listar().subscribe(data =>{
            this.userService.userActualizar.next(data);
          })
        })
      }

      this.cancelar();
    }

    cancelar(){
      this.dialogRef.close();

    }
}

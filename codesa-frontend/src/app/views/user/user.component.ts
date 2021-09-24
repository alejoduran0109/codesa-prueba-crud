import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User } from '../../model/user';
import { MatTableDataSource } from '@angular/material/table';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { UserModalComponent } from './user-modal/user-modal.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  displayedColumns = ['idUsuario', 'nombre', 'idRol', 'activo','editar-eliminar'];
  dataSource!: MatTableDataSource<User>;

  user: User[] | undefined;

  constructor(
    private dialog: MatDialog,
    private userService: UserService) { }


  ngOnInit(): void {
    this.userService.userActualizar.subscribe(data =>{
      this.dataSource = new MatTableDataSource(data);
    })
    this.userService.listar().subscribe(data =>{
      this.dataSource = new MatTableDataSource(data);
    });
  }

  openModal (user?: User){
    let newuser = user != null ? user: new User();
    this.dialog.open(UserModalComponent,{
      width: '260px',
      data: user
    })
  }

  onDelete(id: number){
    let dialogRef = this.dialog.open(ConfirmDialogComponent,{  
      disableClose:true
    });
    dialogRef.afterClosed().subscribe((estado: any) =>{
      if(estado){
        this.userService.eliminar(id).subscribe(()=>{
          this.userService.listar().subscribe(data =>{
            this.dataSource = new MatTableDataSource(data);
          })
        })
      }
    })
    }

    filtrar(valor: string){
      this.dataSource.filter = valor.trim().toLowerCase();
    }
}

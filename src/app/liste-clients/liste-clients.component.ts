import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Client } from '../models/client.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-liste-clients',
  templateUrl: './liste-clients.component.html',
  styleUrls: ['./liste-clients.component.css']
})
export class ListeClientsComponent implements OnInit{

  constructor(private cs: ClientService,
    private router:Router){}



  clients: Array<Client> = [];

  ngOnInit(): void {
      this.cs.getAllClient().subscribe({
        next: data => {
          this.clients = data
        },
        error: err => {
          console.log(err);
        }
      })
  }

  deleteClient(clt : Client){
    if (confirm('Etes-vous sûr de vouloir supprimer? ')){
      this.cs.deleteClient(clt).subscribe({
        next: value =>{
          this.clients = this.clients.filter(p => p.id!= clt.id);
        }
      })
    }
  }

  editerClient(clt: Client){
    this.router.navigateByUrl(`editer-client/${clt.id}`);
  }

}

import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Client } from '../models/client.model';

@Component({
  selector: 'app-liste-clients',
  templateUrl: './liste-clients.component.html',
  styleUrls: ['./liste-clients.component.css']
})
export class ListeClientsComponent implements OnInit{

  constructor(private cs: ClientService){}

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

}

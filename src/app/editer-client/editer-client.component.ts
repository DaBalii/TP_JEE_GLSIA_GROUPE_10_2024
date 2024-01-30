import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-editer-client',
  templateUrl: './editer-client.component.html',
  styleUrls: ['./editer-client.component.css']
})
export class EditerClientComponent implements OnInit {

  updateClient(){
    let client = this.clientForm.value;
    this.clt.editerClient(client).subscribe({
      next : data =>{
        this.router.navigateByUrl("/liste");
      },
      error: err =>{
        console.log(err);
      }
    })
  }

  clientId!:number;
  clientForm!: FormGroup;
  constructor(private activatedRoute:ActivatedRoute,
    private clt: ClientService,
    private fb:FormBuilder,
    private router:Router){}

  ngOnInit(): void {
      this.clientId = this.activatedRoute.snapshot.params['id'];
      this.clt.getClientById(this.clientId).subscribe({
        next: client =>{
          this.clientForm = this.fb.group({
            id : this.fb.control(client.id),
            nom : this.fb.control(client.nom, [Validators.required]),
            prenom : this.fb.control(client.prenom, [Validators.required]),
            courriel : this.fb.control(client.courriel, [Validators.required]),
            adresse : this.fb.control(client.adresse, [Validators.required]),
            sexe : this.fb.control(client.sexe, [Validators.required]),
            nationalite : this.fb.control(client.nationalite, [Validators.required]),
            date_naissance : this.fb.control(client.date_naissance, [Validators.required]),
            numero_telephone : this.fb.control(client.numero_telephone, [Validators.required])
          })
        },
        error: err =>{
          console.log(err);
        }
      })
  }

}

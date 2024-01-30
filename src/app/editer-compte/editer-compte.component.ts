import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CompteService } from '../services/compte.service';

@Component({
  selector: 'app-editer-compte',
  templateUrl: './editer-compte.component.html',
  styleUrls: ['./editer-compte.component.css']
})
export class EditerCompteComponent implements OnInit {

  compteId!:number;
  compteForm!: FormGroup;
  constructor(private activatedRoute: ActivatedRoute,
    private cpt:CompteService,
    private fb:FormBuilder,
    private router:Router){}

  ngOnInit(): void {
      this.compteId = this.activatedRoute.snapshot.params['id'];
      this.cpt.getCompteById(this.compteId).subscribe({
        next:compte =>{
          this.compteForm = this.fb.group({
            id : this.fb.control(compte.id, [Validators.required]),
            numero_compte : this.fb.control(compte.numero_compte, [Validators.required]),
            date_creation: this.fb.control(compte.date_creation, [Validators.required]),
            solde : this.fb.control(compte.solde, [Validators.required]),
            type_compte : this.fb.control(compte.type_compte, [Validators.required]),
            client_id : this.fb.control(compte.client?.id, [Validators.required])
          })
        },
        error: err =>{
          console.log(err);
        }
      })
  }

  updateCompte(){
    let compte = this.compteForm.value;
    this.cpt.updateCompte(compte).subscribe({
      next: data =>{
        this.router.navigateByUrl("/liste-compte");
      },
      error: err =>{
        console.log(err);
      }
    })
  }

}

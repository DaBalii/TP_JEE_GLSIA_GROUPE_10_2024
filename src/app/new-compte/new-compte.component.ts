import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CompteService } from '../services/compte.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-compte',
  templateUrl: './new-compte.component.html',
  styleUrls: ['./new-compte.component.css']
})
export class NewCompteComponent implements OnInit {

  compteForm!: FormGroup;

  constructor(private fb: FormBuilder,
    private cp: CompteService,
    private router: Router){}

  ngOnInit(): void {
      this.compteForm = this.fb.group({
        numero_compte : this.fb.control('', [Validators.required]),
        date_creation : this.fb.control('', [Validators.required]),
        solde : this.fb.control('', [Validators.required]),
        type_compte : this.fb.control('',[Validators.required]),
        client_id : this.fb.control('',[Validators.required])
      })
  };

  saveCompte(){
    let compte = this.compteForm.value;
    this.cp.saveCompte(compte).subscribe({
      next: data =>{
        this.router.navigateByUrl("/liste-compte");
      },
      error: err =>{
        console.log(err);
      }
    })
  }

}

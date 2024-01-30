import { Component, OnInit } from '@angular/core';
import { CompteService } from '../services/compte.service';
import { Router } from '@angular/router';
import { Compte } from '../models/compte.model';

@Component({
  selector: 'app-liste-compte',
  templateUrl: './liste-compte.component.html',
  styleUrls: ['./liste-compte.component.css']
})
export class ListeCompteComponent implements OnInit{

  constructor(private cp: CompteService,
    private router:Router){}

  comptes: Array<Compte> = [];
  ngOnInit(): void {
      this.cp.getAllCompte().subscribe({
        next: data =>{
          this.comptes = data
        },
        error: err =>{
          console.log(err);
        }
      })
  }

  deleteCompte(cpt: Compte){
    if(confirm('Etes-vous sûr de vouloir supprimer ce compte')){
      this.cp.deleteCompte(cpt).subscribe({
        next: value =>{
          this.comptes = this.comptes.filter(p => p.id! = cpt.id);
        }
      })
    }
  }

  editerCompte(cpt: Compte){
    this.router.navigateByUrl(`editer-compte/${cpt.id}`);
  }

}

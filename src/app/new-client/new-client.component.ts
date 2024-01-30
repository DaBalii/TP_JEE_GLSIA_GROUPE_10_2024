import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientService } from '../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {

  clientForm!: FormGroup;
  constructor(private fb:FormBuilder,
    private cs: ClientService,
    private router:Router){}

    ngOnInit(): void {
        this.clientForm = this.fb.group({
          nom : this.fb.control('', [Validators.required]),
          prenom : this.fb.control('', [Validators.required]),
          courriel : this.fb.control('', [Validators.required]),
          sexe : this.fb.control('', [Validators.required]),
          adresse : this.fb.control('', [Validators.required]),
          date_naissance : this.fb.control('', [Validators.required]),
          numero_telephone : this.fb.control('', [Validators.required])
        });
    }

    saveClient(){
      let client = this.clientForm.value;
      this.cs.saveClient(client).subscribe({
        next: data =>{
          this.router.navigateByUrl("/liste");
        },
        error: err =>{
          console.log(err);
        }
      })
    }

}

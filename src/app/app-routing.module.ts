import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserConnexionComponent } from './user-connexion/user-connexion.component';
import { ListeClientsComponent } from './liste-clients/liste-clients.component';
import { NewClientComponent } from './new-client/new-client.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { EditerClientComponent } from './editer-client/editer-client.component';
import { ListeCompteComponent } from './liste-compte/liste-compte.component';
import { EditerCompteComponent } from './editer-compte/editer-compte.component';
import { NewCompteComponent } from './new-compte/new-compte.component';

const routes: Routes = [
  {path: '', component: UserConnexionComponent},
  {path: 'register', component: UserRegisterComponent},
  {path: 'liste', component: ListeClientsComponent},
  {path: 'new', component: NewClientComponent},
  {path: "editer-client/:id", component: EditerClientComponent},
  {path: 'liste-compte', component: ListeCompteComponent},
  {path: 'editer-compte/:id', component: EditerCompteComponent},
  {path: 'new-compte', component:NewCompteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

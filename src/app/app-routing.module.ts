import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserConnexionComponent } from './user-connexion/user-connexion.component';
import { ListeClientsComponent } from './liste-clients/liste-clients.component';
import { NewClientComponent } from './new-client/new-client.component';
import { UserRegisterComponent } from './user-register/user-register.component';

const routes: Routes = [
  {path: '', component: UserConnexionComponent},
  {path: 'register', component: UserRegisterComponent},
  {path: 'liste', component: ListeClientsComponent},
  {path: 'new', component: NewClientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

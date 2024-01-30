import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserConnexionComponent } from './user-connexion/user-connexion.component';
import { ListeClientsComponent } from './liste-clients/liste-clients.component';
import { NewClientComponent } from './new-client/new-client.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditerClientComponent } from './editer-client/editer-client.component';
import { ListeCompteComponent } from './liste-compte/liste-compte.component';
import { EditerCompteComponent } from './editer-compte/editer-compte.component';
import { NewCompteComponent } from './new-compte/new-compte.component';

@NgModule({
  declarations: [
    AppComponent,
    UserConnexionComponent,
    ListeClientsComponent,
    NewClientComponent,
    UserRegisterComponent,
    EditerClientComponent,
    ListeCompteComponent,
    EditerCompteComponent,
    NewCompteComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

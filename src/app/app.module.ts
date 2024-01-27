import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserConnexionComponent } from './user-connexion/user-connexion.component';
import { ListeClientsComponent } from './liste-clients/liste-clients.component';
import { NewClientComponent } from './new-client/new-client.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    UserConnexionComponent,
    ListeClientsComponent,
    NewClientComponent,
    UserRegisterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

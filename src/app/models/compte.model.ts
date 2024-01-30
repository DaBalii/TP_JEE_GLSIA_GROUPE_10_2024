import { Client } from "./client.model"

export enum Type_Compte{
  Courant = 'Courant',
  Epargne = 'Epargne'
}


export interface Compte{
  id : number
  date_creation: Date
  solde : DoubleRange
  numero_compte : string
  type_compte: Type_Compte
  client_id: number
  client?: Client
}

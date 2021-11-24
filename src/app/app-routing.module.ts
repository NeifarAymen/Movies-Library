import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FilmComponent } from './components/film/film.component';
import { ListFilmComponent } from './components/list-film/list-film.component';
import { HomeComponent } from './components/home/home.component';
const routes: Routes = [
  { path: 'FilmForm', component: FilmComponent},
  { path: 'ListeFilm', component: ListFilmComponent},
  { path: '', component: HomeComponent},
 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

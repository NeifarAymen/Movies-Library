import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FilmComponent } from './components/film/film.component';
import { ListFilmComponent } from './components/list-film/list-film.component';
import { FilmService } from './Services/film.service';
import { HeaderComponent } from './shared/layout/header/header.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmComponent,
    ListFilmComponent,
    HeaderComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],

  providers: [FilmService],
  bootstrap: [AppComponent]
})
export class AppModule { }

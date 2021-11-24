import { Injectable } from '@angular/core';
import { Film } from '../Classes/film';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private baseUrl:string='http://localhost:8080/api/films';
  private headers = new Headers({'content-Type':'application/json'});
  film:Film;
  constructor(private _http:HttpClient) { }

getFilms(){
return this._http.get<Film[]>(this.baseUrl) 
}

createFilm(film:Film){
  return this._http.post(this.baseUrl,film)
}

updateFilm(film:Film ){
  return this._http.put<Film[]>(this.baseUrl,film)
}
public deletefilm(id:Number) {
  return this._http.delete<Film>(this.baseUrl+"/"+ id);
}
setter(film:Film){
  this.film=film;
  
}
getter(){
  return this.film;
}
}

import { Component, OnInit } from '@angular/core';
import { FilmService } from 'src/app/Services/film.service';
import { Film } from 'src/app/Classes/film';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-film',
  templateUrl: './list-film.component.html',
  styleUrls: ['./list-film.component.css']
})
export class ListFilmComponent implements OnInit {
    films:Film[];
    film:Film;
    searchFilms:Film[];
    var :boolean=true;
  constructor(private _filmService:FilmService,private _router:Router) { }

  ngOnInit(): void {
    this._filmService.getFilms().subscribe((films)=>{
      console.log(films)
     this.searchFilms= this.films=films;
    },(error)=>{console.log(error);
    });
    
  }
  search(query: string){
    this.searchFilms = (query) ? this.films.filter(film => film.title.toLowerCase().includes(query.toLowerCase()) || film.director.toLowerCase().includes(query.toLowerCase()) ||film.releaseDate.toLowerCase().includes(query.toLowerCase()) || film.type.toLowerCase().includes(query.toLowerCase()) ) : this.films;
    }

    create(){
      let film = new Film();
      this._filmService.setter(film);
        this._router.navigate(['./FilmForm'])
        this.var=true;
    
      }

    update(film){
      this._filmService.setter(film);
      this._router.navigate(['./FilmForm'])
     this.var=false;
      }


    deleteFilm(film){
      if(confirm("Voulez vous vraiment supprimer cet film"))
  {this._filmService.deletefilm(film.id).subscribe((res)=>
    {this.films.splice(this.films.indexOf(film,1));
    },(error)=>{
      console.log(error);
    })

  }
    }

}

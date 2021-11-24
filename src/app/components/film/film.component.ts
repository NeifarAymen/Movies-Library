import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Film } from 'src/app/Classes/film';
import { FilmService } from 'src/app/Services/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {
  film:Film; 
  newFilm=new Film();
  Films: Film[]=[];
  formSubmitted = false;
  filmForm:FormGroup;
  constructor(private filmService:FilmService,private _router:Router,private fb:FormBuilder) { 
    this.initForm();
    this.film=this.filmService.getter();}
   initForm(){
    this.filmForm=this.fb.group({
      title: new FormControl('',[Validators.required]),
      director: new FormControl('',[Validators.required]),
      releaseDate: new FormControl('',[Validators.required]),
      type: new FormControl('',[Validators.required]),      
      });
  }
  onSubmit(){
    const formValue=this.filmForm.value;
      this.newFilm=formValue;
 console.log(this.newFilm)
      
    if ((this.film.id) ===undefined)
    {if(confirm("Voulez vous vraiment enregistrer cet Film"))
      {console.log(formValue);
      this.filmService.createFilm(this.newFilm).subscribe((res:Film)=>{
      this.Films.push(res);
      console.log(this.Films)
      this._router.navigate(['./ListeFilm'])
       },(error)=>{
         console.log(error);
     })  
    }}
  else{if(confirm("Voulez vous vraiment enregistrer cet Film "))
    this.filmService.updateFilm(this.film).subscribe((res)=>{
      console.log(res);
      this._router.navigate(["./ListeFilm"])
    },(error)=>{
      console.log(error);
    
    });
}}
  ngOnInit(): void {
  }

}

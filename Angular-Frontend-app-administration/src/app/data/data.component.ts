import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-dataset',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent implements OnInit {
  dataset:any[]=[];
  data= {
    id:'', //null
    titre: '',
    price:0,
    localisation:'',
    size:0,
    nb_pieces:0,
    nb_chambre: 0, 
    nb_Salles_bain:0,
    etat: '', 
  }

  constructor(
    private appService:AppService
  ) { }

  ngOnInit(): void {
    this.getAllDataSet();
  }
  getAllDataSet(){
    this.appService.getData().subscribe((data: any) => this.dataset = data);
  }

  saveData(){
    if(this.data.id!){
      this.appService.Dataedit(this.data.id,this.data).subscribe(() =>this.getAllDataSet);
    }
    this.data={
    id:'', //null
    titre: '',
    localisation:'',
    price:10,
    size:0,
    nb_pieces:0,
    nb_chambre: 0, 
    nb_Salles_bain:0,
    etat: '', 
    }


  }


  DataDelete(Dataset_id: any){
    this.appService.Datadelete(Dataset_id).subscribe(()=> this.getAllDataSet());
  }

  
  handleChange(data: any) {
    this.data.id = data.id;
    this.data.titre = data.titre;
    this.data.localisation = data.localisation;
    this.data.price = data.price;
    this.data.size = data.size;
    this.data.nb_pieces = data.nb_pieces;
    this.data.nb_chambre = data.nb_chambre;
    this.data.nb_Salles_bain = data.nb_Salles_bain;
    this.data.etat = data.etat;
    
  }

  handleUpdate(e: any , field: number) {

    switch(field) { 
      case 0: { 
        this.data.titre = e.target.value ;
         break; 
      } 
      case 1: { 
        this.data.localisation = e.target.value ;
         break; 
      } 
      case 2: { 
        this.data.size = e.target.value ;
         break; 
      } 
      case 3: { 
        this.data.price = e.target.value ;
         break; 
      } 
      case 4: { 
        this.data.nb_chambre = e.target.value ;
         break; 
      } 
      case 5: { 
        this.data.nb_Salles_bain = e.target.value ;
         break; 
      } 
      case 6: { 
        this.data.etat = e.target.value ;
         break; 
      } 
      case 7: { 

        if(this.data.id!){
          console.log("update");
          this.appService.Dataedit(this.data.id,this.data).subscribe(() =>this.getAllDataSet());
        }else{
          this.appService.saveData(this.data).subscribe(() =>this.getAllDataSet());
        }
        break; 
     } 
      default: { 
         break; 
      } 
   } 
  }

}
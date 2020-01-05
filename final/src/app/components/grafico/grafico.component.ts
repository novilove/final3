import { Component, OnDestroy} from '@angular/core';

@Component({
  selector: 'app-grafico',
  templateUrl: './grafico.component.html',
  styleUrls: ['./grafico.component.css']
})
export class GraficoComponent implements OnDestroy{

  results: any[] =
    [
      {
        "name": "Menores a 18 años",
        "value": 20
      },
      {
        "name": "Entre 18 y 27 años",
        "value": 30
      },
      {
        "name": "Entre 28 y 40 años",
        "value": 15
      },
      {
        "name": "Entre 41 y 60 años",
        "value": 15
      },
      {
        "name": "Entre 60 y más años",
        "value": 15
      }
    ];
  
 


  // options
  showXAxis = true;
  showYAxis = true;
  gradient = true;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Votos';
  showYAxisLabel = true;
  yAxisLabel = 'Juegos';

  colorScheme = 'nightLights';

    intervalo;

  constructor() {


    this.intervalo = setInterval( () => {
      console.log('tick');
      const newResults = [...this.results];

      for(let i in newResults){
        newResults[i].value= Math.round(Math.random() * 500);
      }

      this.results=[...newResults];
    },1500);
    

  }

  onSelect(event) {
    console.log(event);
  }
  ngOnDestroy(){
    clearInterval(this.intervalo);
  }
}

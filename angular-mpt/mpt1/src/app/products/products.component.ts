import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products : Products[];
  constructor(private http : HttpClient ) { 
    this.getDataFromJson();
  }
  getDataFromJson(){

    this.http.get<Products[]>("../../assets/products.json").subscribe(response=>{
      this.products=response;
    });
  }
  ngOnInit() {
  }

}
interface Products{
  name: string;
  image : string;
  price : string;
}
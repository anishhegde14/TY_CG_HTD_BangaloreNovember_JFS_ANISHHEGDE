import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customer : Customer[];
  constructor(private http : HttpClient ) { 

    this.getDataFromJson();
  }


  getDataFromJson(){

    this.http.get<Customer[]>("../../assets/customer.json").subscribe(response=>{
      this.customer=response;
    });
  }
  ngOnInit() {
  }

}
interface Customer{
  name: string;
  email : string;
  phone : string;
}
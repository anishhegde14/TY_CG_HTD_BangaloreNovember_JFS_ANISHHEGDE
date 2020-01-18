import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductsComponent } from './products/products.component';


const routes: Routes = [
{ path : '', component: HomeComponent},
{ path : 'login' , component : LoginComponent},
{path : 'customer', component : CustomerComponent},
{ path : 'product', component : ProductsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

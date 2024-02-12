import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AngularJavaComponent } from './angular-java/angular-java.component';
import { LoginComponent } from './Authentication/login/login.component';
import { SignupComponent } from './Authentication/signup/signup.component';
import { CartComponent } from './cart/cart.component';
import { HeaderComponent } from './header/header.component';

const routes: Routes = [
  {
    path:"login", component:LoginComponent
  },
  {
    path:"signup",component:SignupComponent
  },
  {
    path:"header",component:HeaderComponent
  },
  {
    path:"cart",component:CartComponent
  },
  {
    path:"",component:AngularJavaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

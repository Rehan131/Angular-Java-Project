import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedin:boolean= false;
  public totalItem:number=0;

  constructor(private router:Router,private cartService:CartService) { }

  ngOnInit(): void {
    let log=sessionStorage.getItem('loggedin');
    log == 'true' ? this.loggedin = true : this.loggedin = false;
    
    this.cartService.getProduct()
    .subscribe((res)=>{
      this.totalItem=res.length;
    })
  }


  onLogout(){
    sessionStorage.removeItem('loggedin');
    sessionStorage.removeItem('user_id');
    sessionStorage.removeItem('username');
    this.router.navigate(['/login']);
  }

}
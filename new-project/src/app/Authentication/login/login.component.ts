import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private login:SignupService,private router:Router) { }

  ngOnInit(): void {
  }

  onLogin(f:any){
    this.login.login(f)
    .subscribe((log:any)=>{
      console.log(log);
      sessionStorage.setItem('loggedin','true');
      sessionStorage.setItem('user_id', log.id);
      sessionStorage.setItem('username',log.firstName+' '+log.lastName);
      this.router.navigate(['/']);
    },()=>{
      alert("Login Failed");
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private signup:SignupService) { }

  ngOnInit(): void {
  }

  onSignUp(f:any){
    if(f.password==f.confirmPassword){
      delete f.confirmPassword
    this.signup.postUser(f)
    .subscribe((adduser)=>{
      console.log(adduser);
      alert("Registration successfull");
    })
  
  }else{
    alert("!!Password Doesnt Matches!!");
  }
}
}

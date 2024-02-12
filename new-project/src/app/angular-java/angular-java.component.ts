import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-angular-java',
  templateUrl: './angular-java.component.html',
  styleUrls: ['./angular-java.component.css']
})
export class AngularJavaComponent implements OnInit {

   mobArrobj:any[]=[];
   ishid:boolean=true;
   
   mobArrSpeed:any[]=[];
   ishidspeed:boolean=true;
   
   mobileid:number=0;
   mobileName:string='';
   price:number=0;
   speed:number=0;
   isposthid:boolean=true;

   getOneMobile:any={};
   isonemobhid:boolean=true;

  constructor(private service:HttpService,private cartService:CartService) { }

  ngOnInit(): void {
     this.getAllMobiles();
    // this.getBySpeed();
  }

  getAllMobiles(){
     this.service.getAllMobiles()
     .subscribe((component:any)=>{
       this.mobArrobj=component;
       console.log(this.mobArrobj)
     },(error)=>{
      alert("Error occured");
     })
  }

  getBySpeed(){
    this.service.getByMobSpeed()
    .subscribe((speed:any)=>{
      this.mobArrSpeed=speed;
      this.ishidspeed=false;
    },(error)=>{
      alert("Error occured")
    })
  }

  onSend(data:any){
    console.log(data)
   
    // let jsonobj={
    //    mobileid:this.mobileid,
    //    mobileName:this.mobileName,
    //    price:this.price,
    //    speed:this.speed
    // }

    this.service.addData(data)
    .subscribe((add)=>{
      console.log(add);
      this.ishid=true;
      alert("Data is added successfully");
      this.getAllMobiles();
    },(error)=>{
      alert("Error occured");
    })

  }

  onOpenSend(){
    this.ishid=false;
  }

  updateData:any={};

  onEdit(item:any){
   // console.log(item);
    // this.mobileid=item.mobileid;
    // this.mobileName=item.mobileName;
    // this.price=item.price;
    // this.speed=item.speed;
    this.updateData = item;
    this.isposthid=false;
  }

  onUpdate(){
    // let json={
    //   mobileid:this.mobileid,
    //   mobileName:this.mobileName,
    //   price:this.price,
    //   speed:this.speed
    // }

    this.service.updateData(this.updateData)
    .subscribe((update)=>{
      console.log(update);
      this.isposthid=true;
      alert("Data update successfully")
      this.getAllMobiles();
    },(error)=>{
      alert("Error Occured");
    })
  }

  onDelete(mobileid:any){

    this.service.deleteData(mobileid)
    .subscribe((del)=>{
      console.log(del);
      alert("Data deleted successfully");
      this.getAllMobiles();
    },(error)=>{
      alert("Error occured");
    })
  }

  ongetOnlyOneMobile(mobileid:any){
    this.service.getOneData(mobileid)
    .subscribe((getMob)=>{
      this.getOneMobile=getMob;
      this.isonemobhid=false;
    },(error)=>{
      alert("Error occured while fetching Id")
    })
  }

  addToCart(item:any){
    this.cartService.addtoCart(item);
  }
}

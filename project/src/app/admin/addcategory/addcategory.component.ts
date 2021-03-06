import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../../Admin.service';
// import {AdminService } from 'src/app/Admin.service';
@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.scss']
})
export class AddcategoryComponent implements OnInit {
categoryForm!: FormGroup
  path!: string;
  category: any;
   constructor(private as:AdminService,private router:Router) {}
 ngOnInit(){
  this.as.getCategoryList().subscribe(res=>{
    this.category=res;
    console.log(this.category)
  })
   this.categoryForm = new FormGroup({
    categoryName: new FormControl('', [Validators.required,Validators.minLength(3),Validators.maxLength(15)]),
    categoryLogo: new FormControl('',[Validators.required]),
     categoryDesc: new FormControl('', [
        Validators.required, 
        Validators.minLength(10), 
        Validators.maxLength(100)
      ])
    })
  }
  addCategory()
  {  
    this.path = this.categoryForm.value.categoryLogo
    this.categoryForm.value.categoryLogo = this.path.replace(/^.*\\/, "../../../assets/")
    this.as.addCategory(this.categoryForm.value)
    
    .subscribe({next:() => 
    {
      console.log('');
    }})
   
  }
  
  
  }  
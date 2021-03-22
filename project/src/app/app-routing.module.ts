import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcategoryComponent } from './admin/addcategory/addcategory.component';
import { AddcourseComponent } from './admin/addcourse/addcourse.component';
import { AddvideoComponent } from './admin/addvideo/addvideo.component';
import { AdmincoursepageComponent } from './admin/admincoursepage/admincoursepage.component';
import { CoursepageComponent } from './admin/coursepage/coursepage.component';
import { UnblockuserComponent } from './admin/unblockuser/unblockuser.component';
import { VideopageComponent } from './admin/videopage/videopage.component';

const routes: Routes = [{path:'category-list',component:AdmincoursepageComponent},
                        {path:'add-category',component:AddcategoryComponent},     
                        {path:'add-course',component:AddcourseComponent},
                        {path:'course-list',component:CoursepageComponent},
                        {path:'add-video',component:AddvideoComponent},
                        {path:'video-list',component:VideopageComponent},
                        {path:'unblock-user',component:UnblockuserComponent}

                       
                        
];                  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

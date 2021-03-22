import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { AdmincoursepageComponent } from './admin/admincoursepage/admincoursepage.component';
import { HttpClientModule} from '@angular/common/http';
import { AddcategoryComponent } from './admin/addcategory/addcategory.component';
import { AdminService } from 'src/app/Admin.service';
import { AddcourseComponent } from './admin/addcourse/addcourse.component';
import { CoursepageComponent } from './admin/coursepage/coursepage.component';
import { VideopageComponent } from './admin/videopage/videopage.component';
import { AddvideoComponent } from './admin/addvideo/addvideo.component';
import { AdminSidenavComponent } from './admin/admin-sidenav/admin-sidenav.component';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule } from '@angular/material/expansion';
import { FooterComponent } from './footer/footer.component';




@NgModule({
  declarations: [
    AppComponent,
    AdmincoursepageComponent,
    AddcategoryComponent,
    AddcourseComponent,
    CoursepageComponent,
    VideopageComponent,
    AddvideoComponent,
    AdminSidenavComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatExpansionModule
  ],
  providers: [AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }

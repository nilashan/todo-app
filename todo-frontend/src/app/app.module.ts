import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpUtils } from "./shared/utils/http-utils";
import {ToDoComponent} from "./to-do/to-do.component";
import {TodoService} from "./to-do/service/to-do.service";
import {NotificationUtils} from "./shared/utils/notification-utils";
import {ModalModule} from "./shared/modal/modal.module";


import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import {AppRoutingModule} from "./app.routing";

@NgModule({
  declarations: [
    AppComponent,
    ToDoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule,
    AppRoutingModule,
    ModalModule
  ],
  providers: [HttpUtils,TodoService, NotificationUtils],
  bootstrap: [AppComponent]
})
export class AppModule { }

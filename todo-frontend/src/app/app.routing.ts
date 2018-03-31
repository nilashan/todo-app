import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ToDoComponent} from "./to-do/to-do.component";
import { AppComponent} from "./app.component";


export const routes: Routes = [
  {
    path: '',
    redirectTo: '/todo',
    pathMatch: 'full',
  },

  {
    path: 'todo',
    component: ToDoComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers:[ToDoComponent]
})
export class AppRoutingModule {
}

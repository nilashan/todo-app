import {Component, OnInit} from '@angular/core';
import {TodoService} from "./service/to-do.service";


@Component({
  selector: 'app-to-do',
  templateUrl: './to-do.component.html',
  styleUrls: ['./to-do.component.scss']
})
export class ToDoComponent implements OnInit {
  private _todoLists = null;
  private isCompleted: boolean = false;

  private addTodo = {
    title: '',
    description: ''
  };

  private insertValidateModel = {
    title: '',
    description: ''
  };

  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
    console.log('todo list');
    this.getTodoList();
  }
  getTodoList(){
    this.todoService.getTodoLists()
      .subscribe(
        res => {
          if(res) {
            console.log('response');
            console.log(res);
            this._todoLists = res.data.todoList;
            console.log(this._todoLists);
          }
        }

      );
  }

  addTodoList(){
    if(!this.validateInsert()){
      return;
    }
    let addReq = {
      "title": this.addTodo.title,
      "description": this.addTodo.description
    };
    this.todoService.addTodoLists(addReq)
      .subscribe(
        res => {
          if(res) {
            console.log('response');
            console.log(res);
            this.getTodoList();
          }
        }

      );
  }

  deleteTodoList(todoId: number){

    this.todoService.deleteTodoLists(todoId)
      .subscribe(
        res => {
          if(res) {
            console.log('response');
            console.log(res);
            this.getTodoList();
          }
        }

      );
  }

  changeStatus(index, data){
    let status = null;
    if(data.status == "Completed"){
      status = "Incompleted";
    }
    else {
      status = "Completed";
    }

    let updateReq = {
      "todoId": data.todo_id,
      "status": status
    };
    this.todoService.updateTodoLists(updateReq)
      .subscribe(
        res => {
          if(res) {
            console.log('response');
            console.log(res);
            this.getTodoList();
          }
        }

      );
  }

  validateInsert(){
    this.resetInsertValidate();
    let allow = true;
    if(this.addTodo.title == null || this.addTodo.title =='' || !this.addTodo){
      this.insertValidateModel.title = "Please add a title!";
      allow = false;
    }
    if(this.addTodo.description == null || this.addTodo.description =='' || !this.addTodo.description){
      this.insertValidateModel.description = "Please add a description!";
      allow = false;
    }
    return allow;
  }

  resetInsertValidate(){
    this.insertValidateModel = {
      title: '',
      description: ''
    }
  }

  clearInsert(){
    this.addTodo = {
      title: '',
      description: ''
    };
  }

}

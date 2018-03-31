import {Injectable} from '@angular/core';
import {HttpUtils} from "../../shared/utils/http-utils";
import {CONFIGURATIONS} from "./api-config";
import {TODO_ENDPOINTS} from "./api-endpoints";
import {RequestOptions, Http, Headers} from "@angular/http";

@Injectable()
export class TodoService {

  constructor(private httpUtils: HttpUtils,private http: Http) {
  }

  getTodoLists() {
    let url = CONFIGURATIONS.appRoot + TODO_ENDPOINTS.get_todo_lists;
    return this.httpUtils.httpGet(url);
  }

  addTodoLists(request: Object) {
    let url = CONFIGURATIONS.appRoot + TODO_ENDPOINTS.add_todo_lists;
    return this.httpUtils.httpPost(url, request);
  }

  deleteTodoLists(todoId: number) {
    let url = CONFIGURATIONS.appRoot + TODO_ENDPOINTS.delete_todo_list.replace("${todoId}", todoId.toString());
    return this.httpUtils.httpDelete(url);
  }

  updateTodoLists(request: Object) {
    let url = CONFIGURATIONS.appRoot + TODO_ENDPOINTS.update_todo_list;
    return this.httpUtils.httpPut(url, request);
  }

}

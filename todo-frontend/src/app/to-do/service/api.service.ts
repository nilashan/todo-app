import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {HttpUtils} from "../../shared/utils/http-utils";

@Injectable()
export class ApiService {
  constructor(private _httpUtils: HttpUtils) { }

}

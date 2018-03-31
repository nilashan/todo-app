import {Headers, Http, RequestOptions, ResponseContentType, Response} from "@angular/http";
import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Observable';
import "rxjs/Rx";
import 'rxjs/add/operator/toPromise';
/**
 * Created by nilashan on 3/30/18.
 */

const globalRequestOptions = new RequestOptions({
  headers: new Headers({'Content-Type': 'application/json'}),
  withCredentials: true
});

@Injectable()
export class HttpUtils {

  constructor(private _http: Http) {
  }

  httpGet(url: string, headers?: Headers): any {

    return this._http
      .get(url, (headers != null) ? headers : globalRequestOptions)
      .map((res: any) => this.handleResponse(res))
      .catch((error: any) => this.handleError(error))
      ._finally(() => {

      });
  }

  httpPost(url: string, body: any, headers?: Headers): any {

    return this._http.post(url, body, (headers != null) ? headers : globalRequestOptions)
      .map((res: any) => this.handleResponse(res))
      .catch((error: any) => this.handleError(error))
      ._finally(() => {

      });
  }

  httpPut(url: string, body: any, headers?: Headers): any {

    return this._http.put(url, body, (headers != null) ? headers : globalRequestOptions)
      .map((res: any) => this.handleResponse(res))
      .catch((error: any) => this.handleError(error))
      ._finally(() => {

      });
  }

  httpDelete(url: string, headers?: Headers): any {

    return this._http.delete(url, (headers != null) ? headers : globalRequestOptions)
      .map((res: any) => this.handleResponse(res))
      .catch((error: any) => this.handleError(error))
      ._finally(() => {

      });
  }

 downloadUint8Array(url: string,body): Observable<Uint8Array> {

   return this._http.put(url,body,
     {
       withCredentials: true,
       responseType: ResponseContentType.Blob
     })
     .map(res => {
       return res.json();
     })
     ._finally(() => {

     });
    /*return this._http
      .put(url,body, { responseType: ResponseContentType.ArrayBuffer })
      .map((response: Response) => response.arrayBuffer())
      .map((arrayBuffer: ArrayBuffer) => new Uint8Array(arrayBuffer))
      .first();*/
  }

  private handleResponse(res: any): any {
    if (res) {
      return res.json();
    }
    return null;
  }

  private handleError(error: any) {
    return Observable.throw(error || 'Internal server error');
  }


}

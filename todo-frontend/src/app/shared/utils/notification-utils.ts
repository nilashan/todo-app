import {Injectable} from "@angular/core";
declare let swal;

/**
 * Created by nilashan on 3/30/18.
 */

@Injectable()
export class NotificationUtils {

  public showSadMessage(message?: string) {
    swal({
      title: 'Oops !',
      text: message,
      imageUrl: 'assets/img/sad.gif',
      imageWidth: 110,
      imageHeight: 100,
      animation: false,
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }

  public showErrorMessage(message?: string) {
    swal({
      title: 'Error',
      text: message,
      type: 'error',
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }

  public showSuccessMessage(message?: string) {
    swal({
      title: 'Success',
      text: message,
      type: 'success',
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }
  public showSuccessMessageWithCallBack(message?: string) {
    return swal({
      title: 'Success',
      text: message,
      type: 'success',
      // timer: 4000,
      background: '#f9fbff'
    });

  }

  public showWarningMessage(message?: string) {
    swal({
      title: 'Warning',
      text: message,
      type: 'warning',
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }

  public showInfoMessage(message?: string) {
    swal({
      title: 'Info',
      text: message,
      type: 'info',
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }

 public showInfoHtmlMessage(message?: string) {
    swal({
      title: 'Info',
      html: message,
      type: 'info',
      // timer: 4000,
      background: '#f9fbff'
    }).then(
      function () {
      },
      // handling the promise rejection
      function (dismiss) {
        if (dismiss === 'timer') {
        }
      })
  }

  public promptConfirmation(message?: string) {
    return swal({
      title: 'Are you sure?',
      text: message,
      type: 'warning',
      background: '#f9fbff',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    });
  }

  public promptCustomizeHtml(message?: string,html?:string){
    return swal({
        title: message,
        html: html,
        showCancelButton: true,
        closeOnConfirm: false
      },
      );
  }


}

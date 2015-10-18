import {inject} from 'aurelia-framework';
import $ from 'jquery';
import {DialogService} from 'aurelia-dialog';
import {EditPerson} from './modal-body-example';

@inject(Element, DialogService)
export class Welcome {
  heading = 'Welcome to the Aurelia Navigation App!';
  firstName = 'John';
  lastName = 'Doe';

  title = 'My Modal';

  constructor(element, dialogService) {
    this.element = element;
    this.dialogService = dialogService;
  }

  get fullName() {
    return `${this.firstName} ${this.lastName}`;
  }

  submit() {
    alert(`Welcome, ${this.fullName}!`);
  }

  openModal(){
    console.log("openModal called");
    //$(this.element).find('.modal').modal();

    this.dialogService.open({ viewModel: EditPerson, model: {firstName: 'alex', lastName: 'mueller'}}).then(response => {
      if (!response.wasCancelled) {
        console.log('good');
      } else {
        console.log('bad');
      }
      console.log(response.output);
    });

  }

  onCancelClick(){
    console.log("onCancelClick called");
  }

  onOkClick(){
    console.log("onOkClick called");
  }
}

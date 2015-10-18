import {inject} from 'aurelia-framework';
import $ from 'jquery';

@inject(Element)
export class Welcome {
  heading = 'Welcome to the Aurelia Navigation App!';
  firstName = 'John';
  lastName = 'Doe';

  title = 'My Modal';

  constructor(element) {
    this.element = element;
  }

  get fullName() {
    return `${this.firstName} ${this.lastName}`;
  }

  submit() {
    alert(`Welcome, ${this.fullName}!`);
  }

  openModal(){
    console.log("openModal called");
    $(this.element).find('.modal').modal();
  }

  onCancelClick(){
    console.log("onCancelClick called");
  }

  onOkClick(){
    console.log("onOkClick called");
  }
}

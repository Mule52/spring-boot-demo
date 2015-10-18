import {bindable} from 'aurelia-framework';

export class ModalFooter {
  @bindable buttons = [];
  @bindable parent = '';

  activate(modelData){
    debugger;
    console.log("ModalFooter activate " + modelData);
  }

  onClick(fnString){
    debugger;
    console.log("onCancelClick called = " +  fnString);

    // find object
    var fn = window[fnString];

// is object a function?
    if (typeof fn === "function") fn();


  }
}

import {DialogController} from 'aurelia-dialog';

export class DeleteActor {
  static inject = [DialogController];
  actor = {};

  constructor(dialog){
    this.controller = dialog;
  }

  activate(actor){
    this.actor = actor;
  }
}

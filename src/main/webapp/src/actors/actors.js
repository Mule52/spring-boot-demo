import {inject} from 'aurelia-framework';
import {log} from '../util/utility';
import {ActorApi} from '../api/actor';
import {DialogService} from 'aurelia-dialog';
import {DeleteActor} from './actorDelete';

@inject(ActorApi, DialogService)
export class Actors{
  heading = 'Actors';
  actors = [];
  page = 0;
  size = 20;
  totalElements = 0;
  totalPages = 0;
  currentPage = 0;

  constructor(api, dialogService){
    this.api = api;
    this.dialogService = dialogService;
  }

  // When your route is ready to activate the router will call the activate hook, if present.
  // In the below code, we use this hook to call the GitHub api and get some users back.
  activate(){
    log("Actors activate() is called");
    // call the api to get the data
    this.api.getActors(this.page, this.size).then(results => {
      this.updateViewData(results);
    });
  }

  goToPage(pg){
    if (pg < 0 || pg >= this.totalPages) return;

    this.page = pg;
    this.api.getActors(this.page, this.size).then(results => {
      this.updateViewData(results);
    });
  }

  deleteActor(actor){
    this.dialogService.open({ viewModel: DeleteActor, model: actor }).then(response => {
      if (!response.wasCancelled) {
        this.api.deleteActor(response.output.actorId).then(result => {
          this.goToPage(this.page);
        });
      }
      //else {
      //  console.log('modal was closed by cancel()');
      //}
    });
  }

  updateViewData(results){
    log(results);
    this.totalElements = results.totalElements;
    this.totalPages = results.totalPages;
    this.actors = results.content;
    this.currentPage = results.number;
  }

}

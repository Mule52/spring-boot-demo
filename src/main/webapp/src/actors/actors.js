import {inject} from 'aurelia-framework';
import {log} from '../util/utility';
import {ActorApi} from '../api/actor';
import {DialogService} from 'aurelia-dialog';

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
      log(results);
      this.totalElements = results.totalElements;
      this.totalPages = results.totalPages;
      this.actors = results.content;
      this.currentPage = results.number;
    });
  }

  goToPage(pg){
    if (pg < 0 || pg >= this.totalPages) return;

    this.page = pg;
    this.api.getActors(this.page, this.size).then(results => {
        log(results);
      this.totalElements = results.totalElements;
      this.totalPages = results.totalPages;
      this.actors = results.content;
      this.currentPage = results.number;
    });
  }

  gotToActor(id){
    // redirect to actor details
  // actors/:id/detail
  return false;
  }

  cancel(){
    log("cancel called");
    return false;
  }

  deleteActor(actorId){
    //this.dialogService.open({ viewModel: this.deleteActorDialog, model: actorId}).then(response => {
    //  if (!response.wasCancelled) {
    //    console.log('good - ', response.output);
    //  } else {
    //    console.log('bad');
    //  }
    //  console.log(response.output);
    //});
  }
}

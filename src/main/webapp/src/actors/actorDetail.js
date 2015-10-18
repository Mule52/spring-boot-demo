import {inject} from 'aurelia-framework';
import {log} from '../util/utility';
import {ActorApi} from '../api/actor';

@inject(ActorApi)
export class ActorDetail {
  actor = undefined;
  actorOrig = undefined;
  heading = "Actor Details";

  constructor(api){
    this.api = api;
  }

  activate(params) {
    var id = parseInt(params.id);
    if (Number.isNaN(parseInt(id))){
      // redirect, as the ID is bad
    }
    if (id > 0){
      this.api.getActor(id).then(result => {
        this.setActorProperties(result);
      });
    }
    else {
      log('ssetting empty actor');
      var actor = {firstName:'', lastName:'', lastUpdated:''};
      this.setActorProperties(actor);
    }
  }

  canDeactivate() {
    if (this.dirty) {
      return confirm('You have unsaved changes. Continue?');
    }
    return true;
  }

  get isDirty(){
    if (this.actor == undefined || this.actorOrig == undefined) return false;
    return !(this.actor.firstName == this.actorOrig.firstName && this.actor.lastName == this.actorOrig.lastName);
  }

  save(){
    this.api.save(this.actor).then(result => {
      this.setActorProperties(result);
    });
  }

  setActorProperties(actor){
    this.actorOrig = Object.assign({}, this.actor);
    this.actor = actor;
    if (actor.lastUpdate) {
      var date = new Date(actor.lastUpdate);
      this.actor.lastUpdatedString = date.toLocaleDateString() + " " + date.toLocaleTimeString();
    }
    log(this.actor);
  }
}

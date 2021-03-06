import {transient, inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
import {log} from '../util/utility';

class ResponseInterceptor {
  response(message) {
    return message.response ? JSON.parse(message.response):message;
  }

  responseError(error) {
    throw error; // or return an HttpResponseMessage to recover from the error
  }
}

@inject(HttpClient)
export class ActorApi {

  constructor(http) {
    this.http = http;

    this.http.configure(x => {
      x.withInterceptor(new ResponseInterceptor());
    //x.withInterceptor(new RequestInterceptor());
    x.withHeader("Content-Type", "application/json");
    x.withHeader("Accept", "application/json");
  });
}

  getActors(){
    log('actor.js getActors() called');
    return this.http.get('/api/actor');
  }

  getActors(page, count){
    if (page == undefined || count == undefined) {
      return this.http.get('/api/actor');
    }
    log('actor.js getActors(page, count) called');
    return this.http.get('/api/actor/' + page + '/' + count);
  }

  getActor(id){
    return this.http.get('/api/actor/' + id);
  }

  save(actor){
    if (actor.actorId) {
      return this.http.put('/api/actor', JSON.stringify(actor));
    }
    else {
      return this.http.post('/api/actor', JSON.stringify(actor));
    }
  }

  deleteActor(id){
    return this.http.delete('/api/actor/' + id);
  }
}


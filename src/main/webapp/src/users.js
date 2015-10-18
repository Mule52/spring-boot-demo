import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-fetch-client'; // jspm install aurelia-fetch-client
import 'fetch';

@inject(HttpClient)
export class Users{
  heading = 'Github Users';
  users = [];

  constructor(http){
    http.configure(config => {
      config
      .useStandardConfiguration()
      .withBaseUrl('https://api.github.com/');
  });

    this.http = http;
}

// When your route is ready to activate the router will call the activate hook, if present.
// In the below code, we use this hook to call the GitHub api and get some users back.
activate(){
  return this.http.fetch('users')
    .then(response => response.json())
    .then(users => this.users = users);
  }
}

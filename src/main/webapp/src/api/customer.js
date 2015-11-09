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
export class CustomerApi {

  constructor(http) {
    this.http = http;

    this.http.configure(x => {
      x.withInterceptor(new ResponseInterceptor());
      //x.withInterceptor(new RequestInterceptor());
      x.withHeader("Content-Type", "application/json");
      x.withHeader("Accept", "application/json");
    });
  }

  getCustomers(){
    log('customer.js getCustomers() called');
    return this.http.get('/api/customer');
  }

  getCustomers(page, count){
    if (page == undefined || count == undefined) {
      return this.http.get('/api/customer');
    }
    log('customer.js getCustomers(page, count) called');
    return this.http.get('/api/customer/' + page + '/' + count);
  }

  getCustomer(id){
    return this.http.get('/api/customer/' + id);
  }

  save(customer){
    if (customer.customerId) {
      return this.http.put('/api/customer', JSON.stringify(customer));
    }
    else {
      return this.http.post('/api/customer', JSON.stringify(customer));
    }
  }

  deleteCustomer(id){
    return this.http.delete('/api/customer/' + id);
  }
}


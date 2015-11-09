import 'bootstrap';

export class App {

  configureRouter(config, router){
    config.title = 'Aurelia';
    config.map([
      { route: ['','welcome'],          name: 'welcome',        moduleId: 'welcome',            nav: true, title:'Welcome' },
      { route: 'users',                 name: 'users',          moduleId: 'users',              nav: true, title:'Github Users' },
      { route: 'actors',                name: 'actors',         moduleId: 'actors/actors',      nav: true, title:'Actors' },
      { route: 'actors/:id/detail',     name: 'actorDetail',    moduleId: 'actors/actorDetail', nav: false },
      { route: 'customers',             name: 'customers',      moduleId: 'customers/customers',nav: true, title:'Customers' },
      { route: 'customers/:id/detail',  name: 'customerDetail', moduleId: 'customers/customerDetail', nav: false },
      { route: 'about',                 name: 'about',          moduleId: 'about',              nav: true, title:'About' }
    ]);

    this.router = router;
  }
}


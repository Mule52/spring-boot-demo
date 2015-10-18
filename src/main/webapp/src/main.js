//import 'bootstrap';
import 'github:twbs/bootstrap@3.3.5';

export function configure(aurelia) {

  // see http://aurelia.io/docs.html#startup-and-configuration
  aurelia.use
    .standardConfiguration()
    .developmentLogging()
    .plugin('aurelia-dialog');

  aurelia.start().then(a => a.setRoot());
}

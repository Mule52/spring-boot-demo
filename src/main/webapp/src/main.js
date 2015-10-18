import 'bootstrap';

export function configure(aurelia) {

  //aurelia.globalResources('./modal');
  //aurelia.globalResources('./modal-header');
  //aurelia.globalResources('./modal-body');
  //aurelia.globalResources('./modal-footer');
  //aurelia.globalResources('./au-button');

  // see http://aurelia.io/docs.html#startup-and-configuration
  aurelia.use
    .standardConfiguration()
    .developmentLogging()
    .plugin('aurelia-dialog');

  aurelia.start().then(a => a.setRoot());
}

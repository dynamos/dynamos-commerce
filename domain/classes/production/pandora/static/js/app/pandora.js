/**
 * Created by adelmo.pereira on 03/01/2017.
 */
// Default colors
var brandPrimary =  '#20a8d8';
var brandSuccess =  '#4dbd74';
var brandInfo =     '#63c2de';
var brandWarning =  '#f8cb00';
var brandDanger =   '#f86c6b';

var grayDark =      '#2a2c36';
var gray =          '#55595c';
var grayLight =     '#818a91';
var grayLighter =   '#d1d4d7';
var grayLightest =  '#f8f9fa';

angular
    .module('pandora', [
        'ui.router',
        'oc.lazyLoad',
        'ncy-angular-breadcrumb',
        'blockUI',
        'ui.bootstrap',
        'ngCacheBuster',
        'ngResource',
        'MessageCenterModule'
    ]);

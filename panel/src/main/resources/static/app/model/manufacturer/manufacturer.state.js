/**
 * Created by adelmo.pereira on 24/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').config(config);

    config.$inject = ['$stateProvider'];

    function config($stateProvider) {
        $stateProvider.state('manufacturer', {
            parent: 'default',
            url: '/manufacturer',
            ncyBreadcrumb: {
                label: 'Manufacturer'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/manufacturer/manufacturer.html',
                    controller: 'ListManufacturerController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('manufacturer-create', {
            parent: 'manufacturer',
            url: '/create',
            ncyBreadcrumb: {
                label: 'Create Manufacturer'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/manufacturer/manufacturer-create.html',
                    controller: 'CreateManufacturerController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('manufacturer-edit', {
            parent: 'manufacturer',
            url: '/{id}/edit',
            ncyBreadcrumb: {
                label: 'Edit Manufacturer'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/manufacturer/manufacturer-edit.html',
                    controller: 'EditManufacturerController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
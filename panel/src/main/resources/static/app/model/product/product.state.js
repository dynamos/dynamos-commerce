/**
 * Created by adelmo.pereira on 24/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').config(config);

    config.$inject = ['$stateProvider'];

    function config($stateProvider) {
        $stateProvider.state('product', {
            parent: 'default',
            url: '/product',
            ncyBreadcrumb: {
                label: 'Product'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product/product.html',
                    controller: 'ListProductController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('product-create', {
            parent: 'product',
            url: '/create',
            ncyBreadcrumb: {
                label: 'Create Product'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product/product-create.html',
                    controller: 'CreateProductController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('product-edit', {
            parent: 'product',
            url: '/{id}/edit',
            ncyBreadcrumb: {
                label: 'Edit Product'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product/product-edit.html',
                    controller: 'EditProductController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
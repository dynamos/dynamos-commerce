/**
 * Created by adelmo.pereira on 24/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').config(config);

    config.$inject = ['$stateProvider'];

    function config($stateProvider) {
        $stateProvider.state('product-category', {
            parent: 'default',
            url: '/product-category',
            ncyBreadcrumb: {
                label: 'Product Category'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product-category/product-category.html',
                    controller: 'ListProductCategoryController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('product-category.create', {
            parent: 'product-category',
            url: '/create',
            ncyBreadcrumb: {
                label: 'Create Product Category'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product-category/product-category-create.html',
                    controller: 'CreateProductCategoryController',
                    controllerAs: 'vm'
                }
            }
        });

        $stateProvider.state('product-category.edit', {
            parent: 'product-category',
            url: '/{id}/edit',
            ncyBreadcrumb: {
                label: 'Edit Product Category'
            },
            views: {
                'content@': {
                    templateUrl: 'app/model/product-category/product-category-edit.html',
                    controller: 'EditProductCategoryController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
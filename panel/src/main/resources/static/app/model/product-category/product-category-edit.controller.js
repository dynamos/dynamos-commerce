/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('EditProductCategoryController', controller);

    controller.$inject = ['ProductCategory', '$stateParams', '$state'];

    function controller(ProductCategory, $stateParams, $state) {
        var vm = this;
        vm.save = save;

        ProductCategory.get({id: $stateParams.id}).$promise.then(function (result) {
            vm.productCategory = result;
        });

        function save() {
            ProductCategory.save(vm.productCategory).$promise.then(function () {
                $state.go('product-category');
            });
        }
    }
})();
/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('CreateProductCategoryController', controller);

    controller.$inject = ['ProductCategory', '$state'];

    function controller(ProductCategory, $state) {
        var vm = this;
        vm.save = save;
        vm.productCategory = {};

        function save() {
            ProductCategory.save(vm.productCategory, function () {
                $state.go('product-category');
            });
        }
    }
})();
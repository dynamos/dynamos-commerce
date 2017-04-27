/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('EditProductController', controller);

    controller.$inject = ['Product', '$stateParams', '$state'];

    function controller(Product, $stateParams, $state) {
        var vm = this;
        vm.save = save;

        Product.get({
            id: $stateParams.id
        }, function (result) {
            vm.product = result;
        });

        function save() {
            Product.save(vm.product, function () {
                $state.go('product');
            });
        }
    }
})();
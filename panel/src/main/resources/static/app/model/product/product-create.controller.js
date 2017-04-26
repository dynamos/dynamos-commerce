/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('CreateProductController', controller);

    controller.$inject = ['Product'];

    function controller(Product) {
        var vm = this;
        vm.save = save;
        vm.product = {};

        function save() {
            Product.save(vm.product);
        }
    }
})();
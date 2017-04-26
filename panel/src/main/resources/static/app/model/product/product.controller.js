/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('ListProductController', controller);

    controller.$inject = ['Product'];

    function controller(Product) {
        var vm = this;
        vm.loadAll = loadAll;
        vm.products = [];
        vm.product = {};

        function loadAll() {
            Product.query({
                page: vm.currentPage - 1,
                name: vm.manufacturer.name
            }, onSuccess);

            function onSuccess(result) {
                vm.products = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        loadAll();
    }
})();
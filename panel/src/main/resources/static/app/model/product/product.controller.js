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
        vm.showDescription = showDescription;
        vm.deleteProduct = deleteProduct;

        vm.products = [];
        vm.product = {};
        vm.showDesc = [];

        function loadAll() {
            Product.query({
                page: vm.currentPage - 1,
                name: vm.product.name
            }, onSuccess);

            function onSuccess(result) {
                vm.products = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        function showDescription(index) {
            vm.showDesc[index] = !vm.showDesc[index];
        }

        function deleteProduct(product) {
            openConfirm(product);
        }

        function openConfirm(product) {
            swal({
                title: "Are you sure?",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, disable it!'
            }).then(function () {
                Product.delete(product, loadAll);
            });
        }

        loadAll();
    }
})();
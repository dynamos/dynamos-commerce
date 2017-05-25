/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('ListProductCategoryController', controller);

    controller.$inject = ['ProductCategory'];

    function controller(ProductCategory) {
        var vm = this;

        vm.loadAll = loadAll;
        vm.deleteProductCategory = deleteProductCategory;

        vm.productCategories = [];
        vm.productCategory = {};

        function loadAll() {
            ProductCategory.query({
                page: vm.currentPage - 1,
                name: vm.productCategory.name
            }, onSuccess);

            function onSuccess(result) {
                vm.productCategories = result.content;
                vm.totalItems = result.totalElements;
                vm.currentPage = result.number + 1;
            }
        }

        function deleteProductCategory(productCategory) {
            openConfirm(productCategory);
        }

        function openConfirm(productCategory) {
            swal({
                title: "Are you sure?",
                text: "You will not be able to recover this Product Category " + productCategory.name + "!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then(function () {
                ProductCategory.delete(productCategory, loadAll);
            });
        }
        loadAll();
    }
})();
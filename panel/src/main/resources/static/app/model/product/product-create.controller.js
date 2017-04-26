/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('CreateManufacturerController', controller);

    controller.$inject = ['Manufacturer'];

    function controller(Manufacturer) {
        var vm = this;
        vm.save = save;
        vm.manufacturer = {};

        function save() {
            Manufacturer.save(vm.manufacturer);
        }
    }
})();
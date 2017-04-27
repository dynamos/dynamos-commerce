/**
 * Created by adelmo.pereira on 25/04/2017.
 */
(function () {
    'use strict';

    angular.module('dynamos-panel').controller('EditManufacturerController', controller);

    controller.$inject = ['Manufacturer', '$stateParams', '$state'];

    function controller(Manufacturer, $stateParams, $state) {
        var vm = this;
        vm.save = save;

        Manufacturer.get({
            id: $stateParams.id
        }, function (result) {
            vm.manufacturer = result;
        });

        function save() {
            Manufacturer.save(vm.manufacturer, function(){
                $state.go('manufacturer');
            });
        }
    }
})();
(function() {
    var app = angular.module('contactsManagerApp', ['common', 'spring-security-csrf-token-interceptor']);


    app.controller('contactsManagerCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.logout = function () {
            $http({
                method: 'POST',
                url: '/logout'
            })
                .then(function (response) {
                if (response.status == 200) {
                    window.location.reload();
                }
                else {
                    console.log("Logout failed!");
                }
            });
        };


    }]);

})();

angular.module('loginApp', ['common', 'spring-security-csrf-token-interceptor'])
    .controller('LoginCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.onLogin = function () {
            console.log('Attempting login with email ' + $scope.vm.email + ' and password ' + $scope.vm.password);

            $scope.vm.submitted = true;

            if ($scope.form.$invalid) {
                return;
            }

            $scope.login($scope.vm.email, $scope.vm.password);

        };

    }]);
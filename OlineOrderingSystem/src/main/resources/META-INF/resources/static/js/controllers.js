var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function($scope, $http){
    $scope.refreshCart = function(){
        $http.get('/rest/cart/'+$scope.cartId)
                .success(function(data){
                    $scope.cart = data;
        });
    };
    
    $scope.clearCart = function(){
        $http.delete('/rest/cart/'+$scope.cartId)
                .sucess($scope.refreshCart());
    };
    
    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    }
    
    $scope.addToCart = function (foodId){
        $http.put('/rest/cart/add/'+foodId)
                .success(function (){
                    alert ("Food Successfully added to the Cart!");
                });
    };
    
    $scope.removeFromCart = function(foodId){
        $http.put('/rest/cart/remove/'+foodId)
                .success(function (){
                    $scope.refreshCart();
        });
    };
});
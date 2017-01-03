/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var productApp = angular.module('productApp', []);

productApp.controller('productCtrl', function($scope, $http){
    $scope.getProductById = function(productId) {
        $http.get('/webstore0.1/products/product'+productId)
                .success(function(data){
                    $scope.product = data;
        });
    };
    
    
    
});


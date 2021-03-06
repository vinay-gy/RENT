var app = angular.module('createAd', []);
app.controller('createAdCtrl', function($scope, $http) {
	$scope.showDeposit = true;
	$scope.subCategoryList;
	$scope.sub_category;
	$scope.load_page = "createAd";
	$scope.productTypeList = {
			option : {productType :"Select Type"}
	}
	
	$http.get("category/list")
        .then(function(response) {
        	$scope.categoryList = response.data;
        });
	$scope.changeCategory = function() {
		$("#spinner").show()
		$http.get("subcategory/"+$scope.category)
        .then(function(response) {
        	$scope.subCategoryList = response.data;
        });
		$("#spinner").hide()
    }
	$scope.changeSubCategory = function() {
		$("#spinner").show()
		$('#productType').empty();
		$http.get("producttype/"+$scope.sub_category)
        .then(function(response) {
        	$scope.productTypeList = response.data;
        	
        });
		$('#productType option[value="?"]').remove();
		$("#spinner").hide()
    }
	$scope.changeProduct = function() {
		$scope.productRoute = $scope.product_type.route;
		$scope.productId = $scope.product_type.id;
    }
});
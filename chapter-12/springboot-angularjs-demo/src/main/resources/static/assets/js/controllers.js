var controllers = angular.module('myApp.controllers',[]);

var rootUrl = "http://localhost:8080";

controllers.controller('HomeController',function($scope, $http){
	$http.get(rootUrl+'/posts')
	.success(function(data){
		$scope.posts = data;
	})
	.error(function(data){
		alert('Error');
	});
});

controllers.controller('PostController',function($scope, $http, $routeParams, $location){
	
	var loadPost = function(postId){
		$http.get(rootUrl+'/posts/'+postId)
		.success(function(data){
			$scope.post = data;
		})
		.error(function(data){
			alert('Error');
		});
	}
	
	$scope.deletePost = function(postId){
		$http.delete(rootUrl+'/posts/'+postId)
		.success(function(data){
			$location.path("/posts");
		})
		.error(function(data){
			alert('Error');
		});
	}
	
	loadPost($routeParams.postId);
});


controllers.controller('NewPostController',function($scope, $http, $routeParams, $location){
	
	$scope.newPost = {};
	
	$scope.createPost = function(newPost){
		$http.post(rootUrl+'/posts', newPost)
		.success(function(data){
			$scope.newPost = {};
			$location.path("/posts");
		})
		.error(function(data){
			alert('Error');
		});
	}
	
});
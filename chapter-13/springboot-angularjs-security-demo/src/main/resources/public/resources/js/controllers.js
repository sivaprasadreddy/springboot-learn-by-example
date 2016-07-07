
var myApp = angular.module('myApp');

myApp.controller('LoginController', 
	[ '$rootScope','$scope', '$http', '$state','$location','$cookies', 'UserService','UtilService', 
     function ($rootScope, $scope,$http, $state, $location, $cookies, UserService, UtilService) {
		$scope.loginUser = {};
		
		$scope.authenticateUser = function(){
			
			$scope.loginFailed = false;
			$http({
			    method: 'POST',
			    url: 'login',
			    data: $.param($scope.loginUser),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			})
			
			.then(function(response) {
				//UtilService.notifyInfo('Login successful');
				UserService.setUser(response.data);
				$state.transitionTo('home');
			},function(response) {
				console.log('Login failed');
				$scope.loginFailed = true;
	        	UtilService.notifyError('Invalid Login Credentials');
			});
		};
		
	}
]);

myApp.controller('HomeController', 
   [ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
   function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) {

	$scope.loadPosts = function(page){
		var pageSize = 5;
		
		PostsService.loadPosts(page, pageSize)
			.then(
					function(data, status, headers, config){
						var posts = data.posts;
						angular.forEach(posts, function(post) {
							post.contentPreview = $sce.trustAsHtml(post.contentPreview);
						});
						$scope.posts = posts;
						$scope.postsPagination = {
								hasNextPage : data.hasNextPage,
								hasPrevPage: data.hasPrevPage,
								currentPage: data.currentPage
						};
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in loading posts');
					}
			);
	};
	
	$scope.loadPosts(0);
	
}]);


myApp.controller('PostController', 
	[ '$scope','$http', '$state','$stateParams', '$location', '$sce','UtilService',
    function ($scope, $http, $state, $stateParams, $location,$sce, UtilService) {
	
	$scope.loadPost = function(){
		$http.get('api/posts/'+$stateParams.postId)
		.success(function(data, status, headers, config){
			$scope.post = data;			
		})
		.error(function(data, status, headers, config){
			UtilService.notifyError('Problem in loading post details');
		})
		;
	}

	$scope.loadPost();
	
}]);



myApp.controller('NewPostController', [ '$scope','$http', '$stateParams', '$location', 'UtilService',
    function ($scope, $http, $stateParams, $location, UtilService) {
	
	$scope.newPost = {};
	
	$scope.createPost = function(){
		$http.post('api/admin/posts/', $scope.newPost)
		.success(function(data, status, headers, config){
			UtilService.notifyInfo('Post saved successfully');
			$scope.newPost = {};
		})
		.error(function(data, status, headers, config){
			UtilService.notifyError('Problem in saving post');
		});
	}

}]);


myApp.controller('AdminController',
	[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) 
        {
            console.log('admin controller');
			

		}
    ]
);

myApp.controller('AdminPostsController', 
		[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		   function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService)
    {
		$scope.loadPosts = function(page){
			var pageSize = 5;
			
			PostsService.loadPosts(page, pageSize)
				.then(
						function(data, status, headers, config){
							var posts = data.posts;
							angular.forEach(posts, function(post) {
								post.contentPreview = $sce.trustAsHtml(post.contentPreview);
							});
							$scope.posts = posts;
							$scope.postsPagination = {
									hasNextPage : data.hasNextPage,
									hasPrevPage: data.hasPrevPage,
									currentPage: data.currentPage
							};
						},
						function(data, status, headers, config){
							UtilService.notifyError('Problem in loading posts');
						}
				);
		};
		
		$scope.loadPosts(0);
		
		
		$scope.deletePost = function(postId)
		{
			var r = confirm("Are you sure to delete the post?");
			if (r == true) {
				$http.delete('api/admin/posts/'+postId)
				.then(
					function(data, status, headers, config){
						UtilService.notifyInfo('Post deleted successfully');
						$scope.loadPosts(0);
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in deleteing post');
					}
				);
			}
		}
		
		
	}
]);

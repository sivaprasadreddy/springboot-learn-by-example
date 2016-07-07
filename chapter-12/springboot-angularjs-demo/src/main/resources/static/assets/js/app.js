
var myApp = angular.module('myApp',['ngRoute','myApp.controllers']);

myApp.config(['$routeProvider', '$httpProvider',
    function ($routeProvider, $httpProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'home.html',
                controller: 'HomeController'
            })
            .when('/post/:postId', {
                templateUrl: 'post.html',
                controller: 'PostController'
            })
            .when('/newpost', {
                templateUrl: 'newpost.html',
                controller: 'NewPostController'
            })
            .otherwise({
            	redirectTo: '/home'
            });

    }])
;

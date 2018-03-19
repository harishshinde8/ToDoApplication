'use strict';

angular.module('TodoApp', ['ngRoute']).config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/views/main.html',
                controller: 'MainCtrl',
                resolve: {
                    todos: function ($http) {
                        return $http.get("/todo-app/todo").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })

            .when('/pending', {
                templateUrl: 'app/views/pending.html',
            	controller: 'PendingCtrl',
                resolve: {
                    todos: function ($http) {
                        return $http.get("/todo-app/todo/pending").then(function (response) {
                            return response.data;
                        })
                    }
                }
            }).when('/complete', {
                templateUrl: 'app/views/complete.html',
                controller: 'CompleteCtrl',
                resolve: {
                    todos: function ($http) {
                        return $http.get("/todo-app/todo/complete").then(function (response) {
                            return response.data;
                        })
                    }
                }
            }).otherwise({
                redirectTo: '/'
            });
    });

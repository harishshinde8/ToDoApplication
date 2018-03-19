angular.module('TodoApp')
.controller('CompleteCtrl', ['$scope','todos', function ($scope,todos) {
	$scope.todos=todos;
}])
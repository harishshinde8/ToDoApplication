angular.module('TodoApp')
.controller('PendingCtrl', ['$scope','todos', function ($scope,todos) {
	$scope.todos=todos;
}])
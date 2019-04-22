'use strict'

var module = angular.module('sacumenMachineTestApp.sacumenMachineTestControllers', []);
module.controller("SacumenMachineTestControllers", [ "$scope", "SacumenMachineTestServices",
		function($scope, SacumenMachineTestServices) {

			$scope.data = {};
			SacumenMachineTestServices.getIssueIds()
			.then(function(value){
				console.log(value.data);
				$scope.data = value.data;
			});
			
			/*UserService.getUserById(1).then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});*/

		} ]);
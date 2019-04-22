'use strict'

angular.module('sacumenMachineTestApp.sacumenMachineTestServices', []).factory('SacumenMachineTestServices',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getIssueIds = function() {
				var url = CONSTANTS.getIssueIds;
				return $http.get(url);
			}
			return service;
		} ]);
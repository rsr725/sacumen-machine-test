'use strict'

var demoApp = angular.module('sacumenMachineTestApp', [ 'ui.bootstrap', 'sacumenMachineTestApp.sacumenMachineTestControllers',
		'sacumenMachineTestApp.sacumenMachineTestServices' ]);
demoApp.constant("CONSTANTS", {
	getIssueIds : "/v2/get"
});
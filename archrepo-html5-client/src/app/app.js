angular.module('ngBoilerplate', [
        'templates-app',
        'templates-common',
        'archrepo.home',
        'ui.state',
        'ui.route'
    ])

    .config(function myAppConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/home');
    })

    .run(function run(titleService) {
        titleService.setSuffix(' | ngBoilerplate');
    })

    .controller('AppCtrl', function AppCtrl($scope, $location) {
    })

;


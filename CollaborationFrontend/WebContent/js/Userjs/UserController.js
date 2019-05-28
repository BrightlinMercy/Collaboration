angular.module('myApp').controller(
		'usercontroller',
		function($scope, $route, $rootScope, $location, $http) {
			var curr = this;
			curr.user = {
					userid : 0,
					name : '',
				password : '',
				emailid : '',
				role : '',
				status : '',
				isonline : ''
			};
			
			curr.submit = submit;
			curr.login = login;

			function submit() {
				curr.user.role = 'student';
				curr.user.status = 'true';
				curr.user.isonline = 'false';
				$http.post(
						'http://localhost:8080/CollaborationMiddleware/user',
						curr.user).then(function(response) {
					alert('Registered Successfully');
				}, function(errResponse) {
					alert('Failed to register');
				})
			}

			function login() {
				$http.post(
						'http://localhost:8080/CollaborationMiddleware/login',
						curr.user).then(function(response) {
					alert('Login Successful');
				}, function(errResponse) {
					alert('Login Unsuccessful');
				})
			}

		})

var app = angular.module('myApp', ['ngResource']);

app.controller('EmployeeController', ['$scope', '$resource',function($scope,$resource) {
    
    function fetchAllEmployees(){
        $scope.employees = $resource('http://localhost:8080/employee'
        ).query(function(data){return data;});
    };
    fetchAllEmployees();
    
    $scope.refresh = function(){
    	fetchAllEmployees();
    };
    
    $scope.create = function(){
    	Employee = $resource(
    		    "http://localhost:8080/create",
    		    {},
    		    {save: {method:'PUT',isArray:false}}
    	);
    	
    	var employee = {};
		
		employee.id = $scope.employeeForm.id;
		employee.fullName = $scope.employeeForm.fullName;
		employee.email = $scope.employeeForm.email;
		employee.worksOn = $scope.employeeForm.worksOn;
		
		$scope.Message = Employee.save(employee);
				
		$scope.employeeForm.id = "";
		$scope.employeeForm.fullName="";
		$scope.employeeForm.email="";
		$scope.employeeForm.worksOn="";
    };
    
    $scope.deleteRec = function(){
    	Employee = $resource(
    		    "http://localhost:8080/delete/:id",
    		    {},
    		    {save: {method:'DELETE', params: {id: '@id'}}}
    	);
    	
			
		Employee.delete({id: $scope.employeeForm.id}).then(function successCallback(response) {
			$scope.Message = response;
		}, function errorCallback(response) {
		    
		});
				
		$scope.employeeForm.id = "";
		$scope.employeeForm.fullName="";
		$scope.employeeForm.email="";
		$scope.employeeForm.worksOn="";
    };
    
    
    $scope.update = function(){
    		
    	Employee = $resource(
    		    "http://localhost:8080/update/:id",
    		    {},
    		    {save: {method:'PUT', params: {id: '@id'}}}
    	);
    	
		var employee = {};
		
		employee.id = $scope.employeeForm.id;
		employee.fullName = $scope.employeeForm.fullName;
		employee.email = $scope.employeeForm.email;
		employee.worksOn = $scope.employeeForm.worksOn;
		
		$scope.Message = Employee.save({id: $scope.employeeForm.id}, employee);
				
		$scope.employeeForm.id = "";
		$scope.employeeForm.fullName="";
		$scope.employeeForm.email="";
		$scope.employeeForm.worksOn="";
    };
    
}]);
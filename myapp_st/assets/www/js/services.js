var app = angular.module('starter.services', []);


  app.provider('testmm', function () {

  	 this.$get = ['$rootScope',  '$ionicModal', 
    function ($rootScope, $ionicModal) 
    {


      var provider = {};

      var $scope = $rootScope.$new();
     
      $scope.data = {};

      $ionicModal.fromTemplateUrl('js/testmm.html', {
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function (modal) {
        $scope.modal = modal;
      });

      $scope.$on('$destroy', function () {
        $scope.modal.remove();
      });



      $scope.CloseMe = function () {
         $scope.modal.hide();
      };

 	  $scope.$on('$destroy', function () {
        $scope.modal.remove();
      });


      //Open datepicker popup
      provider.opentTest = function (ipObj) { 
      	 $scope.modal.show();
      };
      /////////////

		return provider;
    }];


/*
   
    this.$get = ['$rootScope',  '$ionicModal', 
    function ($rootScope, $ionicModal) 
    {

      var provider = {};

      var $scope = $rootScope.$new();
     
      $scope.data = {};

      $ionicModal.fromTemplateUrl('testmm.html', {
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function (modal) {
        $scope.modal = modal;
      });

      $scope.$on('$destroy', function () {
        $scope.modal.remove();
      });



      $scope.closeIonicDatePickerModal = function () {
         $scope.modal.hide();
      };

      //Open datepicker popup
      provider.openDatePicker = function (ipObj) {
        var buttons = [];
        delete $scope.fromDate;
        delete $scope.toDate;

        openModal();

      return provider;

    }];
*/
  });

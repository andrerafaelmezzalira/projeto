(function() {

	var ModalDirective = function() {
		return {
			restrict : 'C',
			link : function($scope, $element) {
				$element.modal();
			}
		};
	};

	angular.module('app.directives').directive('modal', ModalDirective);

})();

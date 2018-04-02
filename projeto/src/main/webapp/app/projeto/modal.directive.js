(function() {

	/**
	 * Carrega uma modal para onde tiver o class="modal" definido em html
	 */

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

(function() {

	function ProjetoService($http) {

		var url = 'resources/projeto';

		return ({
			listar : listar,
			salvar : salvar,
			excluir : excluir
		});

		function listar() {
			return $http.get(url);
		}

		function salvar(projeto) {
			var metodo;
			if (!projeto.id) {
				metodo = 'post';
			} else {
				metodo = 'put';
			}
			return $http[metodo](url, projeto);
		}

		function excluir(id) {
			return $http['delete'](url, {
				params : {
					id : id
				}
			});
		}
	}

	ProjetoService.$inject = [ '$http' ];

	angular.module('app.services').service('ProjetoService', ProjetoService);
})();

(function() {

	/**
	 * Representa o serviço de acesso ao servidor responsavel pela gestao de
	 * projetos
	 * 
	 * @param $http
	 * @returns
	 */
	function ProjetoService($http) {

		var url = 'resources/projeto';

		return ({
			listar : listar,
			salvar : salvar,
			excluir : excluir
		});

		/**
		 * Lista de projetos e usuarios
		 */
		function listar() {
			return $http.get(url);
		}
		

		/**
		 * Salva um projeto
		 */
		function salvar(projeto) {
			var metodo;
			if (!projeto.id) {
				metodo = 'post';
			} else {
				metodo = 'put';
			}
			return $http[metodo](url, projeto);
		}

		/**
		 * Exclui um projeto pelo id
		 */
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

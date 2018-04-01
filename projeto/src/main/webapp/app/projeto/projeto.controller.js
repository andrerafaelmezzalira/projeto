(function() {

	function ProjetoController(Status, ProjetoService) {

		var vm = this;

		init();

		function init() {
			vm.salvar = salvar;
			vm.editar = editar;
			vm.excluir = excluir;
			vm.selecionarPessoas = selecionarPessoas;

			vm.status = Status;

			listar();

		}

		function selecionarPessoas() {
			vm.manter.projeto.pessoas = [];
			for ( var idPessoa in vm.pessoasSelecionadas) {
				if (vm.pessoasSelecionadas[idPessoa]) {
					for (var i = 0; i < vm.manter.pessoas.length; i++) {
						if (vm.manter.pessoas[i].id === parseInt(idPessoa)) {
							vm.manter.projeto.pessoas
									.push(vm.manter.pessoas[i]);
							break;
						}
					}
				}
			}
		}

		function listar() {
			ProjetoService.listar().then(function(response) {
				vm.manter = response.data;
			});
		}

		function salvar() {
			ProjetoService.salvar(vm.manter.projeto).then(function(response) {
				M.toast({
					html : response.data.nome + ' salvo com sucesso!'
				})
				listar();
			});
		}

		function editar(projeto) {
			vm.manter.projeto = angular.copy(projeto);
			if (vm.manter.projeto.pessoas) {
				vm.pessoasSelecionadas = {};
				for (var i = 0; i < vm.manter.projeto.pessoas.length; i++) {
					vm.pessoasSelecionadas[vm.manter.projeto.pessoas[i].id] = true;
				}
			}
		}

		function excluir(id) {
			ProjetoService.excluir(id).then(function(response) {
				M.toast({
					html : response.data.nome + ' excluido com sucesso!'
				})
				listar();
			});
		}
	}

	ProjetoController.$inject = [ 'Status', 'ProjetoService' ];

	angular.module('app.controllers').controller('ProjetoController',
			ProjetoController);

})();

(function() {

	/**
	 * 
	 * Representa o controlador da tela de gestao de projetos
	 * 
	 * @param Status
	 * @param ProjetoService
	 * @returns
	 */
	function ProjetoController(Status, ProjetoService) {

		var vm = this;

		init();

		function init() {
			vm.salvar = salvar;
			vm.editar = editar;
			vm.excluir = excluir;
			vm.selecionarPessoas = selecionarPessoas;
			vm.selecionarPessoasGerente = selecionarPessoasGerente;

			vm.status = Status;

			listar();

		}

		/**
		 * Obtem do servidor os projetos e usuarios
		 */
		function listar() {
			ProjetoService.listar().then(function(response) {
				vm.manter = response.data;
				delete vm.pessoasSelecionadas;
				delete vm.gerenteSelecionado;
			});
		}

		/**
		 * Salva um projeto
		 */
		function salvar() {
			ProjetoService.salvar(vm.manter.projeto).then(function(response) {
				M.toast({
					html : response.data.nome + ' salvo com sucesso!'
				})
				listar();
			});
		}

		/**
		 * Carrega o formulario com os dados do projeto para edicao
		 */
		function editar(projeto) {
			vm.manter.projeto = angular.copy(projeto);
			if (vm.manter.projeto.funcionarios) {
				vm.pessoasSelecionadas = {};
				for (var i = 0; i < vm.manter.projeto.funcionarios.length; i++) {
					vm.pessoasSelecionadas[vm.manter.projeto.funcionarios[i].id] = true;
				}
			}
			if (vm.manter.projeto.gerente) {
				vm.gerenteSelecionado = vm.manter.projeto.gerente.id;
			}
		}

		/**
		 * Realiza a exclusao de um projeto
		 */
		function excluir(id) {
			ProjetoService.excluir(id).then(function(response) {
				M.toast({
					html : response.data.nome + ' excluido com sucesso!'
				})
				listar();
			});
		}

		/**
		 * Ao clicar em Fechar o modal, é feito a selecao das pessoas checadadas
		 * para formar o time de membros do projeto
		 */
		function selecionarPessoas() {
			if (!vm.manter.projeto) {
				vm.manter.projeto = {};
			}
			vm.manter.projeto.funcionarios = [];
			for ( var idPessoa in vm.pessoasSelecionadas) {
				if (vm.pessoasSelecionadas[idPessoa]) {
					for (var i = 0; i < vm.manter.pessoas.length; i++) {
						if (vm.manter.pessoas[i].id === parseInt(idPessoa)) {
							vm.manter.projeto.funcionarios
									.push(vm.manter.pessoas[i]);
							break;
						}
					}
				}
			}
		}

		/**
		 * Ao clicar em Fechar o modal, é feito a selecao das pessoa marcada
		 * para tornar gerente do projeto
		 */
		function selecionarPessoasGerente() {
			if (!vm.manter.projeto) {
				vm.manter.projeto = {};
			}
			for (var i = 0; i < vm.manter.pessoas.length; i++) {
				if (vm.manter.pessoas[i].id === parseInt(vm.gerenteSelecionado)) {
					vm.manter.projeto.gerente = vm.manter.pessoas[i];
					break;
				}
			}
		}

	}

	ProjetoController.$inject = [ 'Status', 'ProjetoService' ];

	angular.module('app.controllers').controller('ProjetoController',
			ProjetoController);

})();

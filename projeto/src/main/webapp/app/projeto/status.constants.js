(function() {

	/**
	 * Representa um status de um projeto
	 */
	var Status = [ {
		id : 1,
		descricao : 'Em Análise'
	}, {
		id : 2,
		descricao : 'Análise Realizada'
	}, {
		id : 3,
		descricao : 'Análise Aprovada'
	}, {
		id : 4,
		descricao : 'Iniciado'
	}, {
		id : 5,
		descricao : 'Planejado'
	}, {
		id : 6,
		descricao : 'Em andamento'
	}, {
		id : 7,
		descricao : 'Encerrado'
	}, {
		id : 8,
		descricao : 'Cancelado'
	} ];

	angular.module('app.constants').constant('Status', Status);

})();
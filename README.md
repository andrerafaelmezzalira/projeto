# Projeto
Gerencia projetos de uma empresa

Abaixo segue o que será necessário para a instalação do aplicativo, bem como as tecnologias usadas:
<br/> <br/>
<b>Ferramentas</b>:
<li>JDK 8</li>
<li>Eclipse for Java EE</li> 
<li>Wildfly Java EE7 Full & Web ou qualquer outro servidor que suporte tecnologia Java EE 7</li> 
<br/>
<b>Frameworks</b>:
<li>CDI</li> 
<li>JPA/Hibernate</li> 
<li>EJB 3</li> 
<li>API Rest (javax.ws.rs)</li> 
<li>APi Java EE 7 </li> 
<li>Interface web com Materialize CSS (http://materializecss.com) </li> 
<li>AngularJs</li> 
<li>Maven</li> 
<br/>
<b>Banco de Dados</b>:
<li>Postgres</li> 
<br/>
<b>Testes</b>:
<li>curl (linha de comando em sistema operacional ubuntu)</li> 
<br/>
<b>Instalação</b>:
 <li>Importe o projeto no eclipse, opção (Existing Maven Projects), faça a instalação dos pacotes necessários com Run As -> Maven Install sobre arquivo pom.xml</li>
 <li>O arquivo persistence.xml define o seguinte jta para configurar no servidor java ee 7: java:jboss/projeto. Portanto, para configurar o banco de dados, entre no servidor e mapeie um banco dados para java:jboss/projeto<br/>
Exemplo de entrada no meu arquivo standalone.xml em meu jboss. Incluir dentro de tag < datasources>< /datasources>.<br/>
< datasource jta="true" jndi-name="java:jboss/projeto" pool-name="projeto" enabled="true" use-ccm="true"><br/>
< connection-url>jdbc:postgresql://localhost:5432/projeto</ connection-url><br/>
< driver>postgresql-9.4-1204.jdbc4.jar< /driver><br/>
< security><br/>
< user-name>postgres</ user-name><br/>
< password>postgres</ password><br/>
< /security><br/>
< /datasource><br/><br/>
Criar o banco de dados no postgres, vazio. (A aplicação irá gerar o banco conforme mapeamento feito nas entidades). <br/>
Fazer o deploy também do driver do postgres e apontar nas tags < driver> </ driver>
</li><br/>
<b>Testes Unitários</b>:
 <li>Para testar os serviços, dentro da package resources, tem todos os arquivos em .txt que representa os testes unitários da aplicação. Para rodar os testes, será necessário ter instalado a ferramenta curl em sistema linux.</li>


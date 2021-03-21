# language: pt
Funcionalidade: Cadastro de contas

	Eu como usuário do sistema.
	DESEJO realizar o cadastro de novos usuários.
	PARA QUE seja possível armazenar e gerenciar seus dados.
	
Contexto: 
	Dado que estou acessando a tela de cadastro

@ignore	
Esquema do Cenário:
	E informo o nome <nome>
	E informo o email <email>
	E informo a senha <senha>
	Quando clico em Cadastrar
	Então visualizo mensagem de erro <mensagem>

@ignore
Exemplos:
	|nome					 |email					 |senha		|mensagem											|
	|							 |david@gmail.com|12345678|O campo Nome é obrigatório.	|
	|David Oliveira|							 |12345678|O campo E-mail é obrigatório.|
	|David Oliveira|david@gmail.com|				|O campo Senha é obrigatório.	|
	
Cenário: Cadastrar usuário sem nome
  E informo o e-mail "david@gmail.com"
	E informo a senha "12345678"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro sem nome "O campo Nome é obrigatório."
		
Cenário: Cadastrar usuário sem e-mail
	E informo o nome completo "David Oliveira"
	E informo a senha "12345678"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro sem email "O campo E-mail é obrigatório."
	
Cenário: Cadastrar usuário sem senha
	E informo o nome completo "David Oliveira"
	E informo o e-mail "david@gmail.com"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro sem senha "O campo Senha é obrigatório."

Cenário: Cadastrar usuário sem nenhuma informação
	Quando clico em Cadastrar
	Então visualizo mensagem de erro sem informação "O campo Nome é obrigatório." e "O campo E-mail é obrigatório." e "O campo Senha é obrigatório."
	
Cenário: Cadastrar usuário sem nome completo
	E informo o nome "David"
	E informo o email "david@gmail.com"
	E informo a senha "12345678"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro de nome incompleto "Por favor, insira um nome completo."
	
Cenário: Cadastrar usuário com e-mail inválido
	E informo o nome completo "David Oliveira"
	E informo o email inválido "teste"
	E informo a senha "12345678"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro "Por favor, insira um e-mail válido."

Cenário: Cadastrar usuário com senha com menos de 8 caracteres
	E informo o nome completo "David Oliveira"
	E informo o email "david@gmail.com"
	E informo a senha com menos caracteres "1234567"
	Quando clico em Cadastrar
	Então visualizo mensagem de erro de senha pequena "A senha deve conter ao menos 8 caracteres."
		
Cenário: Cadastrar usuário com dados válidos
	E informo o nome completo 
	E informo o email 
	E informo a senha 
	Quando clico em Cadastrar
	Então visualizo os dados preenchidos na tabela de resultados
	
Cenário: Cadastrar dois usuários com dados válidos
	E informo o nome completo
	E informo o email
	E informo a senha
	E clico em Cadastrar
	E informo o nome completo novo usuário 
	E informo o email	novo usuário 
	E informo a senha novo usuário
	Quando clico em Cadastrar
	Então visualizo os dados dos dois usuários preenchidos na tabela de resultados
	
Cenário: Excluir primeiro usuário cadastrado
	E informo o nome completo
	E informo o email
	E informo a senha
	E clico em Cadastrar
	E informo o nome completo novo usuário 
	E informo o email	novo usuário 
	E informo a senha novo usuário
	E clico em Cadastrar
	Quando clico em excluir
	Então o primeiro usuário é excluido
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
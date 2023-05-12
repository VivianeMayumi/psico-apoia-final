INSERT INTO usuario(id, usuario, senha) VALUES(1, 'teste', 'teste');

INSERT INTO endereco(id, cep, uf, cidade, bairro, logradouro, numero_residencia, complemento) VALUES(1, 1318010, 'SP', 'São Paulo', 'Vila Vila', 'Rua do Teste', 123, 'Casa');

INSERT INTO paciente(id, nome, data_nascimento, numero_cpf, numero_rg, email, telefone, endereco_id, usuario_id) VALUES(1, 'Paciente do Teste', '1955-01-01', '98765432110', '123456789', 'paciente@teste.com.br', '(11) 99999-8888', 1, 1);

INSERT INTO psicologo(id, nome, data_nascimento, numero_crp, numero_cpf, numero_rg, email, telefone, endereco_id) VALUES(1, 'Psicologo do Teste', '1956-01-01', '123-SP', '98765432110', '123456789', 'psicologo@teste.com.br', '(11) 99999-7777', 1);






INSERT INTO usuario(id, usuario, senha, tipo_usuario) VALUES(1, 'paciente', 'paciente', 'PACIENTE');
INSERT INTO usuario(id, usuario, senha, tipo_usuario) VALUES(2, 'psicologo', 'psicologo', 'PSICOLOGO');
ALTER SEQUENCE SEQ_USUARIO RESTART WITH 3;


INSERT INTO endereco(id, cep, uf, cidade, bairro, logradouro, numero_residencia, complemento) VALUES(1, 1318010, 'SP', 'São Paulo', 'Vila Vila', 'Rua do Teste', 123, 'Casa');
INSERT INTO endereco(id, cep, uf, cidade, bairro, logradouro, numero_residencia, complemento) VALUES(2, 1318010, 'SP', 'São Paulo', 'Vila Vila', 'Rua do Teste', 123, 'Casa');
INSERT INTO endereco(id, cep, uf, cidade, bairro, logradouro, numero_residencia, complemento) VALUES(3, 1318010, 'SP', 'São Paulo', 'Vila Vila', 'Rua do Teste', 123, 'Casa');
INSERT INTO endereco(id, cep, uf, cidade, bairro, logradouro, numero_residencia, complemento) VALUES(4, 1318010, 'SP', 'São Paulo', 'Vila Vila', 'Rua do Teste', 123, 'Casa');
ALTER SEQUENCE SEQ_ENDERECO RESTART WITH 5;

INSERT INTO paciente(id, nome, data_nascimento, numero_cpf, numero_rg, email, telefone, endereco_id, usuario_id) VALUES(1, 'Paciente do Teste', '1955-01-01', '98765432110', '123456789', 'paciente@teste.com.br', '(11) 99999-8888', 1, 1);
ALTER SEQUENCE SEQ_PACIENTE RESTART WITH 2;

INSERT INTO psicologo(id, nome, data_nascimento, numero_crp, numero_cpf, numero_rg, email, telefone, endereco_id, usuario_id) VALUES(1, 'Psicologo João do Teste', '1956-01-01', '123-SP', '98765432110', '123456789', 'psicologo.joao@teste.com.br', '(11) 99999-7777', 2, 2);
INSERT INTO psicologo(id, nome, data_nascimento, numero_crp, numero_cpf, numero_rg, email, telefone, endereco_id) VALUES(2, 'Psicologo Maria do Teste', '1955-01-01', '234-SP', '87654321101', '234567890', 'psicologa.maria@teste.com.br', '(11) 88888-6666', 3);
INSERT INTO psicologo(id, nome, data_nascimento, numero_crp, numero_cpf, numero_rg, email, telefone, endereco_id) VALUES(3, 'Psicologo Josefina do Teste', '1954-01-01', '345-SP', '76543211012', '345678901', 'psicologa.josefina@teste.com.br', '(11) 77777-5555', 4);
ALTER SEQUENCE SEQ_PSICOLOGO RESTART WITH 4;

INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(1, 1, '2024-01-01 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(2, 1, '2024-01-02 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(3, 1, '2024-01-03 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(4, 2, '2024-01-01 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(5, 2, '2024-01-02 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(6, 2, '2024-01-03 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(7, 3, '2024-01-01 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(8, 3, '2024-01-02 10.00.00', 'true');
INSERT INTO agenda_psicologo(id, psicologo_id, data_hora, disponivel) VALUES(9, 3, '2024-01-03 10.00.00', 'true');
ALTER SEQUENCE SEQ_AGENDA_PSICOLOGO RESTART WITH 10;

INSERT INTO palestra(id, titulo, data_hora, descricao, palestrante, link) VALUES(1, 'Palestra sobre drogas', '2024-01-03 10.00.00', '1 Essa palestra terá como assunto bla bla bla bla bla', 'Michael Jackson', 'https://meet.google.com/1we-qwer-qwe');
INSERT INTO palestra(id, titulo, data_hora, descricao, palestrante, link) VALUES(2, 'Palestra sobre abuso', '2024-02-03 10.00.00', '2 Essa palestra terá como assunto bla bla bla bla bla', 'Madonna', 'https://meet.google.com/2we-qwer-qwe');
INSERT INTO palestra(id, titulo, data_hora, descricao, palestrante, link) VALUES(3, 'Palestra sobre carreira', '2024-04-03 10.00.00', '3 Essa palestra terá como assunto bla bla bla bla bla', 'Roberto Carlos', 'https://meet.google.com/3we-qwer-qwe');
ALTER SEQUENCE SEQ_PALESTRA RESTART WITH 4;



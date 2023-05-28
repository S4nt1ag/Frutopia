INSERT INTO categoria (nome, descricao) VALUES ('Frutas amarelas', 'Algumas frutas amarelas');
INSERT INTO categoria (nome, descricao) VALUES ('Frutas vermelhas', 'Algumas frutas vermelhas');
INSERT INTO categoria (nome, descricao) VALUES ('Frutas verdes', 'Algumas frutas verdes');

INSERT INTO produto (dataCadastro, descricao, imagem, nome, qtdEstqoeu, valorUnitario, id_categoria_fk) 
VALUES ('2022-03-22T20:50:07.12345','fruta amarela com marcas', 'imagem', 'Banana', 30, 23.0, 1);
INSERT INTO produto (dataCadastro, descricao, imagem, nome, qtdEstqoeu, valorUnitario, id_categoria_fk) 
VALUES ('2023-03-10T20:50:07.12345','frutas vermelhas diversas', 'imagem', 'Maçã', 20, 13.0, 2);
INSERT INTO produto (dataCadastro, descricao, imagem, nome, qtdEstqoeu, valorUnitario, id_categoria_fk) 
VALUES ('2023-04-11T20:50:07.12345','fruta verde sem sementes', 'imagem', 'Uva', 11, 23.0, 3);

INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 23.00, 3, 69.0, 62.1, 1, 1);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 13.00, 4, 52.0, 49.4, 1, 2);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 23.00, 4, 92.0, 82.8, 2, 3);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 13.00, 3, 39.0, 37.5, 2, 2);

INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (1, 4, 111.4, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-04-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (2, 1, 120.3, '', '', '2023-05-20T19:53:07Z');

INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('25545678901', '2001-01-01', 'maria@email.com', 'Maria Teste', '1234', '988888888', 1);
INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('25333378901', '1989-05-20', 'joao@email.com', 'João Teste', '1234', '977777777', 2);

INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Centro', '25689754', 'Petropolis', '3', '10', 'Rua Teste 1', 'RJ');
INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Quitandinha', '25987456', 'Petropolis', '1', '22', 'Rua Teste 2', 'RJ');
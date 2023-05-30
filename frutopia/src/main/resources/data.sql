INSERT INTO categoria (nome, descricao) VALUES ('Frutas amarelas', 'Algumas frutas amarelas');
INSERT INTO categoria (nome, descricao) VALUES ('Frutas vermelhas', 'Algumas frutas vermelhas');
INSERT INTO categoria (nome, descricao) VALUES ('Frutas verdes', 'Algumas frutas verdes');

INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2022-03-22T20:50:07.12345','Fruta suculenta, saborosa e visualmente cativante, uma delícia tropical.', 'imagem', 'Abacaxi Rosa', 30, 23.0, 2);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-03-10T20:50:07.12345','Fruta doce, macia, nutritiva, versátil, excelente fonte de energia.', 'imagem', 'Banana Nanica', 20, 13.0, 1);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-04-11T20:50:07.12345','Fruta exótica, suculenta, refrescante, tropical, levemente ácida, com formato estrelado.', 'imagem', 'Carambola', 11, 31.0, 1);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2022-03-22T20:50:07.12345','Fruta pequena, peluda, refrescante, doce com toque ácido, cheio de vitamina C e fibras.', 'imagem', 'Kiwi', 30, 23.0, 3);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-03-10T20:50:07.12345','Fruta alaranjada, cheia de sabor, fonte de vitamina C.', 'imagem', 'Mamão Papaya', 20, 13.0, 3);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-04-11T20:50:07.12345','Fruta suculenta, tropical, doce, cor vibrante, saborosa e aromática.', 'imagem', 'Manga', 11, 23.0, 1);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2022-03-22T20:50:07.12345','Fruta exótica, suculenta, agridoce, cor intensa, aroma marcante.', 'imagem', 'Maracujá Vermelho', 30, 32.0, 2);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-03-10T20:50:07.12345','Fruta suave, macia, delicadamente doce, textura suculenta e refrescante.', 'imagem', 'Pera', 20, 17.0, 2);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-04-11T20:50:07.12345','Fruta exótica, vibrante, refrescante, sabor levemente adocicado, textura crocante.', 'imagem', 'Pitaya', 11, 43.0, 2);
INSERT INTO produto (data_cadastro, descricao, imagem, nome, qtd_estoque, valor_unitario, id_categoria_fk) 
VALUES ('2023-04-11T20:50:07.12345','Fruta pequena, vermelho intenso, sabor doce e ácido, típico africano.', 'imagem', 'Rambutão', 11, 28.0, 2);

INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Centro', '12345678', 'São Paulo', 'Bloco A', '123', 'Rua das Flores', 'SP');
INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Jardim Botânico', '54321987', 'Rio de Janeiro', 'Apto 201', '456', 'Avenida das Palmeiras', 'RJ');
INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Vila Nova', '98765432', 'Porto Alegre', 'Casa Verde', '789', 'Rua dos Pinheiros', 'RS');
INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Centro Histórico', '24680135', 'Salvador', 'Sala 302', '321', 'Travessa das Laranjeiras', 'BA');
INSERT INTO endereco (bairro, cep, cidade, complemento, numero, rua, uf) 
VALUES ('Alphaville', '13579024', 'Barueri', 'Condomínio Residencial', '654', 'Alameda dos Ipês', 'SP');

INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('12345678910', '1985-03-15', 'joao@example.com', 'João da Silva', '2341', '1198765432', 1);
INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('98765432100', '1990-07-25', 'maria@example.com', 'Maria Souza', '5678', '2199998888', 2);
INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('55588899977', '1988-11-02', 'carlos@example.com', 'Carlos Santos', '9012', '5112345678', 3);
INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('22233344455', '1995-09-10', 'ana@example.com', 'Ana Silva', '3456', '7155552222', 4);
INSERT INTO cliente (cpf, data_nascimento, email, nome_completo, senha, telefone, id_endereco_fk) 
VALUES ('77722211100', '1982-12-30', 'pedro@example.com', 'Pedro Oliveira', '7890', '1187654321', 5);

INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (1, 4, 111.4, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-04-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (2, 1, 120.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-05-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (3, 2, 137.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-06-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (4, 5, 90.7, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-07-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (5, 2, 58.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-08-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (1, 4, 131.4, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-09-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (2, 1, 170.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-10-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (3, 2, 35.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-11-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (4, 5, 190.7, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-12-20T19:53:07Z');
INSERT INTO pedido (id_cliente_fk, status, valor_total, data_entrega, data_envio, data_pedido)
VALUES (5, 2, 98.3, '2023-11-28T16:51:12', '2023-06-06T16:51:12', '2023-01-20T19:53:07Z');

INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 23.00, 3, 69.0, 62.1, 1, 1);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 13.00, 4, 52.0, 49.4, 1, 2);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 31.00, 4, 124.0, 111.6, 2, 3);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 23.00, 3, 69.0, 65.55, 2, 4);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 13.00, 3, 39.0, 35.1, 1, 5);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 23.00, 4, 92.0, 87.4, 1, 6);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 32.00, 4, 128.0, 115.2, 2, 7);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 17.00, 3, 51.0, 48.45, 2, 8);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (10.00, 43.00, 3, 129.0, 116.1, 1, 9);
INSERT INTO item_pedido (percentual_desconto, preco_venda, quantidade, valor_bruto, valor_liquido,
id_pedido_fk, id_produto_fk) VALUES (5.00, 28.00, 4, 112.0, 106.4, 1, 10);
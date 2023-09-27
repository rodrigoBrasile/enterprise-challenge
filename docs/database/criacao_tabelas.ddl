CREATE TABLE cliente_fornecedor (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    cpf_cnpj VARCHAR(11) NOT NULL,
                                    nome VARCHAR(255) NOT NULL,
                                    email VARCHAR(255) NOT NULL,

                                    telefone1_tipo VARCHAR(255) NOT NULL,
                                    telefone1_numero VARCHAR(255) NOT NULL,

                                    telefone2_tipo VARCHAR(255),
                                    telefone2_numero VARCHAR(255),

                                    endero_logradouro VARCHAR(255) NOT NULL,
                                    endero_numero VARCHAR(255) NOT NULL,
                                    endero_bairro VARCHAR(255) NOT NULL,
                                    endero_estado VARCHAR(2) NOT NULL,
                                    endero_cep VARCHAR(8) NOT NULL);

insert into cliente_fornecedor(cpf_cnpj, nome, email, telefone1_tipo, telefone1_numero, telefone2_tipo, telefone2_numero, endero_logradouro, endero_numero, endero_bairro, endero_estado, endero_cep)
    value ('11122233341', 'Chico Bento', 'chicobento@gmail.com', 'CELULAR', '11982286666', null, null, 'Av. da Internet', '444', 'Interlagos', 'SP', '18000200');
insert into cliente_fornecedor(cpf_cnpj, nome, email, telefone1_tipo, telefone1_numero, telefone2_tipo, telefone2_numero, endero_logradouro, endero_numero, endero_bairro, endero_estado, endero_cep)
    value ('34156624897', 'Rodrigo', 'rodrigo@gmail.com', 'CELULAR', '11982281234', null, null, 'Av. da bla bla', '63', 'zago', 'SP', '18000200');
insert into cliente_fornecedor(cpf_cnpj, nome, email, telefone1_tipo, telefone1_numero, telefone2_tipo, telefone2_numero, endero_logradouro, endero_numero, endero_bairro, endero_estado, endero_cep)
    value ('33355599987', 'Iago Pikachu', 'iago@gmail.com', 'CELULAR', '11982285987', null, null, 'Rua das flores', '1', 'bla', 'SP', '18000200');
insert into cliente_fornecedor(cpf_cnpj, nome, email, telefone1_tipo, telefone1_numero, telefone2_tipo, telefone2_numero, endero_logradouro, endero_numero, endero_bairro, endero_estado, endero_cep)
    value ('65198751980', 'Gabriel Neves', 'gabriel@gmail.com', 'CELULAR', '11982285649', null, null, 'travessa 123', '52', 'inter', 'SP', '18000200');


CREATE TABLE material(
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         id_cliente_fornecedor INT NOT NULL,
                         FOREIGN KEY (id_cliente_fornecedor ) REFERENCES cliente_fornecedor(id),
                         descricao VARCHAR(255) NOT NULL,
                         unidade VARCHAR(255) NOT NULL,
                         codigo_fabricante VARCHAR(255) NOT NULL,
                         custo DECIMAL(10,2) NOT NULL);

insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (1, 'Tecido Azul', 'METRO', '001', 10);
insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (1, 'Tecido Amarelo', 'METRO', '002', 15);
insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (1, 'logo fiap', 'UNIDADE', '003', 5);
insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (2, 'Tecido Branco', 'UNIDADE', '001', 7);
insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (2, 'Tecido Cor de calabresa', 'UNIDADE', '002', 7);

CREATE TABLE produto(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        descricao VARCHAR(255) NOT NULL,
                        preco DECIMAL(10,2) NOT NULL);

insert into produto (descricao, preco)
values ('camiseta fiap', 75);
insert into produto (descricao, preco)
values ('camiseta calabreso', 80);

CREATE TABLE detalhe_produto(
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                id_produto INT NOT NULL,
                                FOREIGN KEY (id_produto) REFERENCES produto(id),
                                id_material INT NOT NULL,
                                FOREIGN KEY (id_material) REFERENCES material(id),
                                quantidade DECIMAL(10,2));

insert into detalhe_produto (id_produto, id_material, quantidade)
values (1, 1, 1);
insert into detalhe_produto (id_produto, id_material, quantidade)
values (1, 2, 1);
insert into detalhe_produto (id_produto, id_material, quantidade)
values (1, 3, 1);
insert into detalhe_produto (id_produto, id_material, quantidade)
values (2, 4, 1);
insert into detalhe_produto (id_produto, id_material, quantidade)
values (2, 5, 1);

CREATE TABLE ordem_venda(
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            id_cliente INT NOT NULL,
                            FOREIGN KEY (id_cliente) REFERENCES cliente_fornecedor(id),
                            status varchar(80) not null,
                            data_entrega DATE NOT NULL,
                            logradouro VARCHAR(255) NOT NULL,
                            numero VARCHAR(255) NOT NULL,
                            bairro VARCHAR(255) NOT NULL,
                            estado VARCHAR(255) NOT NULL,
                            CEP VARCHAR(8) NOT NULL,
                            informacoes_adicionais VARCHAR(255) NOT NULL);

insert into ordem_venda (id_cliente, status, data_entrega, logradouro, numero, bairro, estado, CEP, informacoes_adicionais)
values (1, 'AGUARDANDO_PRODUCAO','2023-10-15', 'Av Interlagos', '123', 'Logo ali', 'SP', '18200000', '....aqui são as informações adicionais');

insert into ordem_venda (id_cliente, status, data_entrega, logradouro, numero, bairro, estado, CEP, informacoes_adicionais)
values (1, 'EM_PRODUCAO', '2023-10-07', 'Av da Internet', '321', 'bairro', 'SP', '18200000', '....aqui são as informações adicionais');

CREATE TABLE detalhe_ordem_venda(
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    id_ordem_venda INT NOT NULL,
                                    FOREIGN KEY (id_ordem_venda) REFERENCES ordem_venda(id),
                                    id_produto INT NOT NULL,
                                    FOREIGN KEY (id_produto) REFERENCES produto(id),
                                    quantidade INT NOT NULL,
                                    desconto DECIMAL NOT NULL);

insert into detalhe_ordem_venda (id_ordem_venda, id_produto, quantidade, desconto)
values (1, 1, 1, 0);

insert into detalhe_ordem_venda (id_ordem_venda, id_produto, quantidade, desconto)
values (2, 1, 1, 0);
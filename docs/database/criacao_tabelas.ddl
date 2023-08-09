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
    value ('1112223334', 'Chico Bento', 'chicobento@gmail.com', 'CELULAR', '11982286666', null, null, 'Av. da Internet', '444', 'Interlagos', 'SP', '18000200');


CREATE TABLE material(
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         id_cliente_fornecedor INT NOT NULL,
                         FOREIGN KEY (id_cliente_fornecedor ) REFERENCES cliente_fornecedor(id),
                         descricao VARCHAR(255) NOT NULL,
                         unidade VARCHAR(255) NOT NULL,
                         codigo_fabricante VARCHAR(255) NOT NULL,
                         custo DECIMAL(10,2) NOT NULL);

insert into material(id_cliente_fornecedor, descricao, unidade, codigo_fabricante, custo)
    value (1, 'Tecido Azul', 'METRO', '001', 100);

CREATE TABLE produto(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        descricao VARCHAR(255) NOT NULL,
                        preco DECIMAL(10,2) NOT NULL);

CREATE TABLE detalhe_produto(
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                id_produto INT NOT NULL,
                                FOREIGN KEY (id_produto) REFERENCES produto(id),
                                id_material INT NOT NULL,
                                FOREIGN KEY (id_material) REFERENCES material(id),
                                quantidade DECIMAL(10,2));

CREATE TABLE ordem_venda(
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            data_criacao DATE NOT NULL,
                            id_cliente_fornecedor INT NOT NULL,
                            FOREIGN KEY (id_cliente_fornecedor) REFERENCES cliente_fornecedor(id),
                            data_entrega DATE NOT NULL,
                            logradouro VARCHAR(255) NOT NULL,
                            numero VARCHAR(255) NOT NULL,
                            bairro VARCHAR(255) NOT NULL,
                            estado VARCHAR(255) NOT NULL,
                            CEP VARCHAR(8) NOT NULL);

CREATE TABLE detalhe_ordem_venda(
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    id_ordem_venda INT NOT NULL,
                                    FOREIGN KEY (id_ordem_venda) REFERENCES ordem_venda(id),
                                    id_produto INT NOT NULL,
                                    FOREIGN KEY (id_produto) REFERENCES produto(id),
                                    quantidade INT NOT NULL,
                                    desconto DECIMAL NOT NULL);
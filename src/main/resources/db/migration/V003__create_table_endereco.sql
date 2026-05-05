drop table endereco;
CREATE TABLE endereco(
    id BIGINT NOT NULL AUTO_INCREMENT,
    cep CHAR(08) NOT NULL, 
    logradouro VARCHAR(100) NOT NULL,
    numero int NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    uf CHAR(2) NOT NULL,
    dataAtualizacao DATETIME NOT NULL,
    PRIMARY KEY(id)
);

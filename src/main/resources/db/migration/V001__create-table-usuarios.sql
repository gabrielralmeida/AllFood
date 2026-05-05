CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    userlogin VARCHAR(100) NOT NULL,
    tipousuario CHAR(1) NOT NULL,
    dataAtualizacao DATETIME NOT NULL,

    PRIMARY KEY(id)
);

INSERT INTO usuarios (id, nome, email, senha, userlogin, tipousuario, dataAtualizacao) VALUES(1, 'Administrador', 'admin@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'admin', 'A', CURRENT_TIMESTAMP);

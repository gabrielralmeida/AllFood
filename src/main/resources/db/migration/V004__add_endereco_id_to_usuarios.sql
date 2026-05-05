ALTER TABLE usuarios
    ADD COLUMN endereco_id BIGINT NULL,
    ADD UNIQUE KEY uk_usuarios_endereco_id (endereco_id),
    ADD CONSTRAINT fk_usuarios_endereco FOREIGN KEY (endereco_id) REFERENCES endereco (id);

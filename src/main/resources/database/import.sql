-- Inserir usuario admin e permissoes, usuario: admin senha: admin
INSERT INTO tb_usuario (id_usuario, username, email, password) values (1, 'admin', 'admin@admin.com', '$2a$10$PUIJUx4LaGS/6JkQIxIcv.DdJVI6w5wvpyw1Q26.GFbyjSnv1qPxG');
INSERT INTO tb_permissao (id_permissao, descricao) values (1, 'ROLE_ADMIN');
INSERT INTO rl_usuario_permissao (id_usuario, id_permissao) values (1, 1);
insert into genero (nome) values ('Pop');
INSERT into genero (nome) values ('Rock');
Insert into genero (nome) values ('Calypso');
insert into genero (nome) values ('MPB');

insert into artista (nome, descricao) values ('Banda Calypso', 'Banda Calypso foi uma banda brasileira de calypso, com influências de ritmos regionais do estado de origem. O conjunto foi formado em Belém no estado do Pará, em 10 de junho de 1999, pela cantora e dançarina Joelma Mendes e pelo guitarrista e produtor musical, Cledivan Almeida Farias, mais conhecido como Ximbinha.');
insert into artista (nome, descricao) values ('Banda Kassikó', 'Banda de Recife (PE), formada em 2000, influenciada por estilos como Calypso, Melody e Forró, além do ritmo caribenho Kasseko, que deu origem ao nome do grupo.');
insert into artista (nome, descricao) values ('Anitta', 'Larissa de Macedo Machado, mais conhecida pelo seu nome artístico Anitta, é uma cantora, compositora, atriz, dançarina e empresária brasileira.');

insert into faixa (nome) values ('A Lua Me Traiu');
insert into faixa (nome) values ('Pra Te Esquecer');
insert into faixa (nome) values ('Tchau Pra Você');

insert into compositor (nome) values ('Joelma Mendes');
insert into compositor (nome) values ('Ximbinha');
insert into compositor (nome) values ('Anitta');

insert into faixa_compositor (id_faixa, id_compositor) values (1, 1);
insert into faixa_compositor (id_faixa, id_compositor) values (2, 2);
insert into faixa_compositor (id_faixa, id_compositor) values (3, 3);

insert into edicaoespecial (descricao, preco, estoque, id_album) values ('Edição especial com Poster', 39.90, 100, 2);
insert into edicaoespecial (descricao, preco, estoque, id_album) values ('Edição especial com Adesivo', 39.90, 100, 3);

insert into classificacaoetaria (descricao) values ('Livre');
insert into classificacaoetaria (descricao) values ('10 anos');
insert into classificacaoetaria (descricao) values ('12 anos');


insert into telefone (codigoArea, numero) values (11, 111111111);
insert into telefone (codigoArea, numero) values (22, 222222222);
insert into telefone (codigoArea, numero) values (11, 333333333);
INSERT INTO telefone (codigoArea, numero) VALUES (11, 444444444);
INSERT INTO telefone (codigoArea, numero) VALUES (11, 555555555);

insert into estado (nome, sigla) values ('Tocantins', 'TO');
insert into estado (nome, sigla) values ('São Paulo', 'SP');

INSERT INTO municipio (nome, id_estado) VALUES ('Palmas', 1);
INSERT INTO municipio (nome, id_estado) VALUES ('Campinas', 2);

INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, id_municipio) VALUES ('Rua A', 'Bairro X', '123', 'Apto 456', '12345-678', 1);
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, id_municipio) VALUES ('Rua B', 'Bairro Y', '456', 'Apto 789', '12345-678', 2);
insert into endereco (logradouro, bairro, numero, complemento, cep, id_municipio) values ('Rua C', 'Bairro Z', '789', 'Apto 101', '12345-678', 2);


insert into usuario (nome, login, senha, cpf, perfil) values ('luis', 'luiss', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '609.688.453-99', 2);
insert into usuario (nome, login, senha, cpf, perfil) values ('emily', 'emilyy', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '071.548.466-56', 1);
insert into usuario (nome, login, senha, cpf, perfil) values ('eduardo', 'eduardoo', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '999.999.999-99', 2);
insert into usuario (nome, login, senha, cpf, perfil) values ('nome3', 'login3', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '999.999.999-99', 1);
insert into usuario (nome, login, senha, cpf, perfil) values ('nome4', 'login4', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '999.999.999-99', 2);
insert into usuario (nome, login, senha, cpf, perfil) values ('nome5', 'login5', 'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==', '999.999.999-99', 2);

insert into usuario_telefone (id_usuario, id_telefone) values (1, 1);
insert into usuario_telefone (id_usuario, id_telefone) values (1, 2);
insert into usuario_telefone (id_usuario, id_telefone) values (2, 3);
insert into usuario_telefone (id_usuario, id_telefone) values (2, 4);
insert into usuario_telefone (id_usuario, id_telefone) values (3, 5);

insert into usuario_endereco (id_usuario, id_endereco) values (1, 1);
insert into usuario_endereco (id_usuario, id_endereco) values (2, 2);
insert into usuario_endereco (id_usuario, id_endereco) values (3, 3);


insert into usuario_endereco (id_usuario, id_endereco) values (2, 1);


insert into gravadora (nome) values ('Sony Music');
insert into gravadora (nome) values ('Universal Music Group');
insert into gravadora (nome) values ('Republic Records');
insert into gravadora (nome) values ('Independente/Desconhecida');

insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('O Ritmo Que Conquistou o Brasil!', '2002', 'é o segundo álbum de estúdio da banda musical brasileira Banda Calypso, lançado em dezembro de 2002 através de sua gravadora independente Calypso Produções.', 29.90, 100, 3, 1, 4, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Ao Vivo em Palmas/TO', '2005', 'gravado ao vivo na cidade de Palmas (TO), para um público de mais de 70 mil pessoas. O disco vendeu em poucos meses 100 mil cópias.', 39.90, 100, 1, 1, 4, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Kisses', '2019', 'é o quarto álbum de estúdio da artista musical brasileira Anitta, lançado em 5 de abril de 2019 pela Warner Music Brasil. Seguindo a proposta de seu EP Solo (2018), Kisses é um álbum trilíngue, compreendendo as línguas espanhola, inglesa e portuguesa. Além disso, é um projeto visual; isto é, cada canção possui seu próprio vídeo musical. Recebeu uma indicação na 20ª edição do Grammy Latino como Melhor Álbum de Música Urbana.', 29.90, 100, 1, 3, 2, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Funk Generetion', '2024', 'Funk Generation é o futuro sexto álbum de estúdio da cantora brasileira Anitta, com previsão de lançamento para 26 de abril de 2024, através da Republic. Promete ser o primeiro projeto internacional da artista voltado exclusivamente ao funk, sendo seu terceiro disco trilíngue.', 29.90, 100, 3, 3, 3, 'CD');



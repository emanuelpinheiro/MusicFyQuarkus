--inserção de estados do Brasil no bd
insert into estado (nome, sigla) values ('Acre', 'AC');
insert into estado (nome, sigla) values ('Alagoas', 'AL');
insert into estado (nome, sigla) values ('Amapá', 'AP');
insert into estado (nome, sigla) values ('Amazonas', 'AM');
insert into estado (nome, sigla) values ('Bahia', 'BA');
insert into estado (nome, sigla) values ('Ceará', 'CE');
insert into estado (nome, sigla) values ('Distrito Federal', 'DF');
insert into estado (nome, sigla) values ('Espírito Santo', 'ES');
insert into estado (nome, sigla) values ('Goiás', 'GO');
insert into estado (nome, sigla) values ('Maranhão', 'MA');
insert into estado (nome, sigla) values ('Mato Grosso', 'MT');
insert into estado (nome, sigla) values ('Mato Grosso do Sul', 'MS');
insert into estado (nome, sigla) values ('Minas Gerais', 'MG');
insert into estado (nome, sigla) values ('Pará', 'PA');
insert into estado (nome, sigla) values ('Paraíba', 'PB');
insert into estado (nome, sigla) values ('Paraná', 'PR');
insert into estado (nome, sigla) values ('Pernambuco', 'PE');
insert into estado (nome, sigla) values ('Piauí', 'PI');
insert into estado (nome, sigla) values ('Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado (nome, sigla) values ('Rio Grande do Sul', 'RS');
insert into estado (nome, sigla) values ('Rondônia', 'RO');
insert into estado (nome, sigla) values ('Roraima', 'RR');
insert into estado (nome, sigla) values ('Santa Catarina', 'SC');
insert into estado (nome, sigla) values ('São Paulo', 'SP');
insert into estado (nome, sigla) values ('Sergipe', 'SE');
insert into estado (nome, sigla) values ('Tocantins', 'TO');

--inserção das capitais dos estados do Brasil no bd
insert into cidade (nome, id_estado) values ('Rio Branco', 1);
insert into cidade (nome, id_estado) values ('Maceió', 2);
insert into cidade (nome, id_estado) values ('Macapá', 3);
insert into cidade (nome, id_estado) values ('Manaus', 4);
insert into cidade (nome, id_estado) values ('Salvador', 5);
insert into cidade (nome, id_estado) values ('Fortaleza', 6);
insert into cidade (nome, id_estado) values ('Brasília', 7);
insert into cidade (nome, id_estado) values ('Vitória', 8);
insert into cidade (nome, id_estado) values ('Goiânia', 9);
insert into cidade (nome, id_estado) values ('São Luís', 10);
insert into cidade (nome, id_estado) values ('Cuiabá', 11);
insert into cidade (nome, id_estado) values ('Campo Grande', 12);
insert into cidade (nome, id_estado) values ('Belo Horizonte', 13);
insert into cidade (nome, id_estado) values ('Belém', 14);
insert into cidade (nome, id_estado) values ('João Pessoa', 15);
insert into cidade (nome, id_estado) values ('Curitiba', 16);
insert into cidade (nome, id_estado) values ('Recife', 17);
insert into cidade (nome, id_estado) values ('Teresina', 18);
insert into cidade (nome, id_estado) values ('Rio de Janeiro', 19);
insert into cidade (nome, id_estado) values ('Natal', 20);
insert into cidade (nome, id_estado) values ('Porto Alegre', 21);
insert into cidade (nome, id_estado) values ('Porto Velho', 22);
insert into cidade (nome, id_estado) values ('Boa Vista', 23);
insert into cidade (nome, id_estado) values ('Florianópolis', 24);
insert into cidade (nome, id_estado) values ('São Paulo', 25);
insert into cidade (nome, id_estado) values ('Aracaju', 26);
insert into cidade (nome, id_estado) values ('Palmas', 27);

--inserção de usuários no bd (senha = 123)
insert into usuario (nome, login, senha, cpf, perfil) values ('emanuel', 'emanueluser', 'R0ey52dhS6JXwvmpAi12w1SeOjANcDdfovBq1xeSbj8bCJ7fsVUzUyxwEFrT98KAQGDZE3YAmXFf+aPKNHJ39Q==', '609.688.453-99', 2);
insert into usuario (nome, login, senha, cpf, perfil) values ('emily', 'emilyuser', 'R0ey52dhS6JXwvmpAi12w1SeOjANcDdfovBq1xeSbj8bCJ7fsVUzUyxwEFrT98KAQGDZE3YAmXFf+aPKNHJ39Q==', '071.548.466-56', 2);
insert into usuario (nome, login, senha, cpf, perfil) values ('cliente', 'clienteuser', 'R0ey52dhS6JXwvmpAi12w1SeOjANcDdfovBq1xeSbj8bCJ7fsVUzUyxwEFrT98KAQGDZE3YAmXFf+aPKNHJ39Q==', '999.999.999-99', 1);

--inserção de telefones no bd
insert into telefone (codigoArea, numero) values (11, 111111111);
insert into telefone (codigoArea, numero) values (22, 222222222);
insert into telefone (codigoArea, numero) values (11, 333333333);
INSERT INTO telefone (codigoArea, numero) VALUES (11, 444444444);
INSERT INTO telefone (codigoArea, numero) VALUES (11, 555555555);

--adição de telefones aos usuários
insert into usuario_telefone (id_usuario, id_telefone) values (1, 1);
insert into usuario_telefone (id_usuario, id_telefone) values (1, 2);
insert into usuario_telefone (id_usuario, id_telefone) values (2, 3);
insert into usuario_telefone (id_usuario, id_telefone) values (2, 4);
insert into usuario_telefone (id_usuario, id_telefone) values (3, 5);

--inserção de endereços no bd
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, id_municipio) VALUES ('Rua A', 'Bairro X', '123', 'Apto 456', '12345-678', 1);
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, id_municipio) VALUES ('Rua B', 'Bairro Y', '456', 'Apto 789', '12345-678', 2);
insert into endereco (logradouro, bairro, numero, complemento, cep, id_municipio) values ('Rua C', 'Bairro Z', '789', 'Apto 101', '12345-678', 2);

--adição de endereços aos usuários
insert into usuario_endereco (id_usuario, id_endereco) values (1, 1);
insert into usuario_endereco (id_usuario, id_endereco) values (2, 2);
insert into usuario_endereco (id_usuario, id_endereco) values (3, 3);
insert into usuario_endereco (id_usuario, id_endereco) values (2, 1);

--inserção de gravadoras no bd
insert into gravadora (nome) values ('Sony Music');
insert into gravadora (nome) values ('Universal Music Group');
insert into gravadora (nome) values ('Republic Records');
insert into gravadora (nome) values ('Independente/Desconhecida');

--inserção de gêneros musicais no bd
insert into genero (nome) values ('Pop');
INSERT into genero (nome) values ('Rock');
Insert into genero (nome) values ('Calypso');
insert into genero (nome) values ('MPB');

--inserção de classificação etária no bd
insert into classificacaoetaria (descricao) values ('Livre');
insert into classificacaoetaria (descricao) values ('10 anos');
insert into classificacaoetaria (descricao) values ('12 anos');

--inserção de artistas no bd
insert into artista (nome, descricao) values ('Banda Calypso', 'Banda Calypso foi uma banda brasileira de calypso, com influências de ritmos regionais do estado de origem. O conjunto foi formado em Belém no estado do Pará, em 10 de junho de 1999, pela cantora e dançarina Joelma Mendes e pelo guitarrista e produtor musical, Cledivan Almeida Farias, mais conhecido como Ximbinha.');
insert into artista (nome, descricao) values ('Banda Kassikó', 'Banda de Recife (PE), formada em 2000, influenciada por estilos como Calypso, Melody e Forró, além do ritmo caribenho Kasseko, que deu origem ao nome do grupo.');
insert into artista (nome, descricao) values ('Anitta', 'Larissa de Macedo Machado, mais conhecida pelo seu nome artístico Anitta, é uma cantora, compositora, atriz, dançarina e empresária brasileira.');

--inserção de compositores no bd
insert into compositor (nome) values ('Joelma Mendes');
insert into compositor (nome) values ('Ximbinha');
insert into compositor (nome) values ('Anitta');

--inserção de faixas musicais no bd
insert into faixa (nome) values ('A Lua Me Traiu');
insert into faixa (nome) values ('Pra Te Esquecer');
insert into faixa (nome) values ('Tchau Pra Você');

--inserção de faixas e compositores no bd
insert into faixa_compositor (id_faixa, id_compositor) values (1, 1);
insert into faixa_compositor (id_faixa, id_compositor) values (2, 2);
insert into faixa_compositor (id_faixa, id_compositor) values (3, 3);

--inserção de faixas e artistas no bd
insert into edicaoespecial (descricao, preco, estoque, id_album) values ('Edição especial com Poster', 39.90, 100, 2);
insert into edicaoespecial (descricao, preco, estoque, id_album) values ('Edição especial com Adesivo', 39.90, 100, 3);

--inserção de álbuns no bd
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('O Ritmo Que Conquistou o Brasil!', '2002', 'é o segundo álbum de estúdio da banda musical brasileira Banda Calypso, lançado em dezembro de 2002 através de sua gravadora independente Calypso Produções.', 29.90, 100, 3, 1, 4, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Ao Vivo em Palmas/TO', '2005', 'gravado ao vivo na cidade de Palmas (TO), para um público de mais de 70 mil pessoas. O disco vendeu em poucos meses 100 mil cópias.', 39.90, 100, 1, 1, 4, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Kisses', '2019', 'é o quarto álbum de estúdio da artista musical brasileira Anitta, lançado em 5 de abril de 2019 pela Warner Music Brasil. Seguindo a proposta de seu EP Solo (2018), Kisses é um álbum trilíngue, compreendendo as línguas espanhola, inglesa e portuguesa. Além disso, é um projeto visual; isto é, cada canção possui seu próprio vídeo musical. Recebeu uma indicação na 20ª edição do Grammy Latino como Melhor Álbum de Música Urbana.', 29.90, 100, 1, 3, 2, 'CD');
insert into album ( nome, anoLancamento, descricao, preco, estoque, id_artista, id_genero, id_gravadora, tipoProduto) values ('Funk Generetion', '2024', 'Funk Generation é o futuro sexto álbum de estúdio da cantora brasileira Anitta, com previsão de lançamento para 26 de abril de 2024, através da Republic. Promete ser o primeiro projeto internacional da artista voltado exclusivamente ao funk, sendo seu terceiro disco trilíngue.', 29.90, 100, 3, 3, 3, 'CD');
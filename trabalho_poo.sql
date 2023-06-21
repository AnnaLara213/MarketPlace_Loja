create database poo3;
use poo3;

create table Usuario(
	idUsuario integer auto_increment,
    email varchar(60) not null,
    senha varchar(45) not null,
    telefone varchar(11) not null,
    permissao integer not null,
    constraint pk_usuario primary key (idUsuario)
);

create table Endereco(
	idEndereco integer not null,
	cep varchar(8) not null,
    logradouro varchar(70) not null,
    numero integer not null,
    complemento varchar(70),
    bairro varchar(70) not null,
    estado varchar(2) not null,
    cidade varchar(70) not null,
    constraint pk_endereco primary key (idEndereco)
);

create table Cliente(
	idCliente integer not null,
    nome varchar(100) not null,
    documento varchar(14) not null,
    dataNascimento date,
    usuario integer not null,
    endereco integer not null,
    constraint pk_cliente primary key (idCliente),
    constraint fk_usuarioCliente foreign key (usuario) references Usuario(idUsuario),
    constraint fk_enderecoCliente foreign key (endereco) references Endereco(idEndereco)
);

create table Cartao(
	idCartao integer not null,
    bandeira integer not null,
    numeroCartao integer not null,
    dataValidade date,
    cvc integer not null,
    cliente integer not null,
    constraint pk_cartao primary key (idCartao),
    constraint fk_cartaoCliente foreign key (cliente) references Cliente(idCliente)
);

create table Lojista(
	idLojista integer not null,
	nomeFantasia varchar(60) not null,
    documento varchar(14) not null,
    licencaEmpresarial varchar(45) not null,
    nomeResponsavel varchar(60) not null,
    usuario integer not null,
    endereco integer not null,
    constraint pk_lojista primary key (idLojista),
    constraint fk_usuarioLojista foreign key (usuario) references Usuario(idUsuario),
    constraint fk_enderecoLojista foreign key (endereco) references Endereco(idEndereco)
);

create table Produto(
	idProduto integer not null,
	nome varchar(100) not null,
    categoria integer not null,
    marca varchar(45) not null,
    descricao varchar(180) not null,
    qtEstoque integer not null,
    preco float not null,
    cor varchar(45),
    dimensao varchar(45),
    material varchar(45),
    modelo varchar(45),
    lojista integer not null,
    constraint pk_produto primary key (idProduto),
    constraint fk_lojistaProduto foreign key (lojista) references Lojista(idLojista)
	
);

create table Carrinho(
	quantidade integer not null,
    precoTotal float not null,
    produto integer not null,
    cliente integer not null,
    constraint pk_lista primary key (produto, cliente),
    constraint fk_produtoCarrinho foreign key (produto) references Produto(idProduto),
    constraint fk_clienteCarrinho foreign key (cliente) references Cliente(idCliente)
);

create table Lista_de_desejo(
    produto integer not null,
    cliente integer not null,
    constraint pk_lista primary key (produto, cliente),
    constraint fk_produtoLista foreign key (produto) references Produto(idProduto),
    constraint fk_clienteLista foreign key (cliente) references Cliente(idCliente)
);

create table Avaliacao(
    produto integer not null,
    cliente integer not null,
    constraint pk_avaliacao primary key (produto, cliente),
    constraint fk_produtoAvaliacao foreign key (produto) references Produto(idProduto),
    constraint fk_clienteAvaliacao foreign key (cliente) references Cliente(idCliente)
);

create table Venda(
	idVenda integer not null,
    dataVenda date not null,
    cliente integer not null,
    cartao integer not null,
    lojista integer not null,
    constraint pk_venda primary key (idVenda),
    constraint fk_clienteVenda foreign key (cliente) references Cliente(idCliente),
    constraint fk_cartaoVenda foreign key (cartao) references Cartao(idCartao),
    constraint fk_lojistaVenda foreign key (lojista) references Lojista(idLojista)
);

create table itensVenda(
    quantidade integer not null,
    valorTotal float not null,
    produto integer not null,
    venda integer not null,
    constraint pk_itens primary key (produto),
    constraint fk_produtoItens foreign key (produto) references Produto(idProduto),
    constraint fk_vendaItens foreign key (venda) references Venda(idVenda)
);

create table Reembolso(
	idReembolso integer not null,
    quantidade integer not null,
    cliente integer not null,
    produto integer not null,
    venda integer not null,
    constraint pk_reembolso primary key (idReembolso),
    constraint fk_clienteReembolso foreign key (cliente) references Cliente(idCliente),
    constraint fk_produtoReembolso foreign key (produto) references Produto(idProduto),
    constraint fk_vendaReembolso foreign key (venda) references Venda(idVenda)
);
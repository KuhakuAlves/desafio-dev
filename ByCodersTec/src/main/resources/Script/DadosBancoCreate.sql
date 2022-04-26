CREATE TABLE public.dadosbanco (
	codigo int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	tipotransacao int NOT NULL,
	dataTransacao varchar(14) NOT NULL,
	valor numeric NOT NULL,
	cpf varchar(12) NULL,
	cartao varchar(30) NULL,
	hora varchar(12) NULL,
	nmdono varchar(100) NULL,
	nmloja varchar(100) NULL
);
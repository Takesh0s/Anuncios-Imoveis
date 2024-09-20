insert into Proprietario (nome, cpf, telefone, email) 
values 
    ('Elaine Eliane Antonella Ribeiro', '653.948.777-00', '(62) 98613-7418', 'elaine-ribeiro90@maptec.com.br'),
    ('Larissa Rafaela Sales', '575.916.853-33', '(91) 99406-8118', 'larissa_sales@uninorte.com.br'),
    ('Rayssa Marli da Silva', '428.363.315-18', '(79) 99621-9129', 'rayssa-dasilva88@simsvale.com.br'),
    ('Josefa Luana Fátima Araújo', '044.705.575-52', '(88) 99538-2577', 'josefa_luana_araujo@apso.org.br');

insert into Imovel (endereco, tipo, preco, area, id_proprietario) 
values 
    ('Rua Teste, 123', 'Apartamento', 1500.00, 80.00, 1),
    ('Av. Central, 456', 'Casa', 2500.00, 120.00, 2),
    ('Rua Nova, 789', 'Cobertura', 3500.00, 150.00, 3),
    ('Rua das Flores, 321', 'Terreno', 100000.00, 300.00, 1);

insert into Interessado (nome, telefone, email) 
values 
    ('Benício Edson Caldeira', '(67) 98719-9293', 'benicio_caldeira@delboux.com.br'),
    ('Manoel Henrique Costa', '(82) 99707-4736', 'manoel_henrique_costa@amaralmonteiro.com.br'),
    ('Pietro Bento Figueiredo', '(88) 98777-3696', 'pietro-figueiredo98@icloud.com'),
    ('Henrique Matheus Fernandes', '(84) 99283-0538', 'henrique-fernandes80@macroengenharia.com');

insert into Contrato (tipo_contrato, data_contrato, valor, id_imovel, id_proprietario, id_interessado) 
values 
    ('Compra', curdate(), 200000.00, 1, 1, 1),
    ('Aluguel', curdate(), 12000.00, 2, 2, 2);

insert into Pagamento (data_pagamento, valor_pago, id_contrato) 
values 
    (curdate(), 5000.00, 1),
    (curdate(), 3000.00, 1),
    (curdate(), 2000.00, 2),
    (curdate(), 1500.00, 2);

select * from contrato;
select * from proprietario;
select * from imovel;
select * from interessado;
select * from pagamento;
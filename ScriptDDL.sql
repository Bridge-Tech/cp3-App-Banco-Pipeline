DROP TABLE tb_conta cascade constraints;
DROP TABLE tb_cliente cascade constraints;
            
CREATE TABLE tb_cliente (
    id     NUMBER(30) NOT NULL,
    nome   VARCHAR2(30) NOT NULL,
    endereco  VARCHAR2(30) NOT NULL,
    documento  VARCHAR2(30) NOT NULL,
    dt_nascimento  VARCHAR2(30) NOT NULL,
    tipo   VARCHAR2(30) NOT NULL
);

ALTER TABLE tb_cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id );   

CREATE TABLE tb_conta (
    id     NUMBER(10) NOT NULL,
    agencia   NUMBER(10) NOT NULL,
    numero   NUMBER(10) NOT NULL,
    saldo     NUMBER(10) NOT NULL,
    vl_saldo     NUMBER NOT NULL,
    dt_abertura  VARCHAR2(30) NOT NULL,
    tipo   VARCHAR2(30) NOT NULL
);

ALTER TABLE tb_conta ADD CONSTRAINT conta_pk PRIMARY KEY ( id );
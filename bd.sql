--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14
-- Dumped by pg_dump version 10.14

-- Started on 2020-11-12 11:40:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2828 (class 1262 OID 16417)
-- Name: controle_patrimonio; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE controle_patrimonio WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE controle_patrimonio OWNER TO postgres;

\connect controle_patrimonio

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16463)
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marca (
    id bigint NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.marca OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16461)
-- Name: marca_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marca_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marca_id_seq OWNER TO postgres;

--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 197
-- Name: marca_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marca_id_seq OWNED BY public.marca.id;


--
-- TOC entry 196 (class 1259 OID 16437)
-- Name: marcabkp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marcabkp (
    id bigint,
    nome character varying(255)
);


ALTER TABLE public.marcabkp OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16471)
-- Name: patrimonio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.patrimonio (
    numero_tombo bigint NOT NULL,
    descricao character varying(255),
    nome character varying(255),
    marca_id bigint
);


ALTER TABLE public.patrimonio OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16469)
-- Name: patrimonio_numero_tombo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.patrimonio_numero_tombo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patrimonio_numero_tombo_seq OWNER TO postgres;

--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 199
-- Name: patrimonio_numero_tombo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.patrimonio_numero_tombo_seq OWNED BY public.patrimonio.numero_tombo;


--
-- TOC entry 202 (class 1259 OID 16489)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    token character varying(255)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16487)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2833 (class 0 OID 0)
-- Dependencies: 201
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- TOC entry 2688 (class 2604 OID 16466)
-- Name: marca id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca ALTER COLUMN id SET DEFAULT nextval('public.marca_id_seq'::regclass);


--
-- TOC entry 2689 (class 2604 OID 16474)
-- Name: patrimonio numero_tombo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patrimonio ALTER COLUMN numero_tombo SET DEFAULT nextval('public.patrimonio_numero_tombo_seq'::regclass);


--
-- TOC entry 2690 (class 2604 OID 16492)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- TOC entry 2692 (class 2606 OID 16468)
-- Name: marca marca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (id);


--
-- TOC entry 2696 (class 2606 OID 16479)
-- Name: patrimonio patrimonio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patrimonio
    ADD CONSTRAINT patrimonio_pkey PRIMARY KEY (numero_tombo);


--
-- TOC entry 2698 (class 2606 OID 16499)
-- Name: usuario uk_5171l57faosmj8myawaucatdw; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk_5171l57faosmj8myawaucatdw UNIQUE (email);


--
-- TOC entry 2694 (class 2606 OID 16481)
-- Name: marca uk_ix7qqllivg82mpp45cgolja3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT uk_ix7qqllivg82mpp45cgolja3 UNIQUE (nome);


--
-- TOC entry 2700 (class 2606 OID 16497)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2701 (class 2606 OID 16482)
-- Name: patrimonio fk1rpn3p8il8p6whc6kjeiei96q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patrimonio
    ADD CONSTRAINT fk1rpn3p8il8p6whc6kjeiei96q FOREIGN KEY (marca_id) REFERENCES public.marca(id);


-- Completed on 2020-11-12 11:40:44

--
-- PostgreSQL database dump complete
--


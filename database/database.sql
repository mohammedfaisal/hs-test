--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-07-27 01:46:04

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16397)
-- Name: employee; Type: TABLE; Schema: public; Owner: emsadmin
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    name text NOT NULL,
    code text NOT NULL,
    designation text
);


ALTER TABLE public.employee OWNER TO emsadmin;

--
-- TOC entry 202 (class 1259 OID 16395)
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: emsadmin
--

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO emsadmin;

--
-- TOC entry 2822 (class 0 OID 0)
-- Dependencies: 202
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: emsadmin
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- TOC entry 2688 (class 2604 OID 16400)
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: emsadmin
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- TOC entry 2690 (class 2606 OID 16405)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: emsadmin
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


-- Completed on 2020-07-27 01:46:04

--
-- PostgreSQL database dump complete
--


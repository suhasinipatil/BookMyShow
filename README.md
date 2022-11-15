Server [localhost]:
Database [postgres]:
Port [5432]:
Username [postgres]:
Password for user postgres:
psql (14.6)
WARNING: Console code page (437) differs from Windows code page (1252)
8-bit characters might not work correctly. See psql reference
page "Notes for Windows users" for details.
Type "help" for help.

postgres=# select version();
version
------------------------------------------------------------
PostgreSQL 14.6, compiled by Visual C++ build 1914, 64-bit
(1 row)

postgres=# create database bookmyshow;
CREATE DATABASE
postgres=# create user bookmyshowuser;
CREATE ROLE
postgres=# grant all privileges on database bookmyshow to bookmyshowuser;
GRANT
postgres=# ALTER USER "bookmyshowuser" WITH PASSWORD '-----';
ALTER ROLE
postgres=# 
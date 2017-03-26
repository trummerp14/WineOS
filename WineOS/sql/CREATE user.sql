USE WINE_OS;
GO

--CREATE LOGIN [reader] WITH PASSWORD=N'reader', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[Deutsch], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
--CREATE USER [reader] FOR LOGIN [reader] WITH DEFAULT_SCHEMA=[dbo]
--CREATE ROLE readonly;
REVOKE update,delete,insert,execute,references FROM readonly;
GRANT SELECT TO readonly;
EXEC sp_addrolemember 'readonly', 'reader';
GO

--CREATE LOGIN [writer] WITH PASSWORD=N'writer', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[Deutsch], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
--CREATE USER [writer] FOR LOGIN [writer] WITH DEFAULT_SCHEMA=[dbo]
--CREATE ROLE readandwrite;
REVOKE delete FROM readandwrite;
GRANT select, insert, update, execute TO readandwrite;
EXEC sp_addrolemember 'readandwrite', 'writer';
GO

--CREATE LOGIN [admin] WITH PASSWORD=N'admin', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[Deutsch], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
--CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo];
--CREATE ROLE admins;
GRANT select, insert, update, delete, execute, references TO admins;
EXEC sp_addrolemember 'admins', 'admin';
GO
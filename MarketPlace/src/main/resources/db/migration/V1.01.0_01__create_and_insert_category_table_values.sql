DECLARE @sql NVARCHAR(MAX);
IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = N'RiskV2')
BEGIN
    SET @sql = N'CREATE SCHEMA [MarketPlace] AUTHORIZATION [dbo];';
    EXEC sp_executesql @sql;
END
GO


IF NOT EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'Category' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
         CREATE TABLE [MarketPlace].[Category](
            [Id] INT IDENTITY (1, 1) NOT NULL,
            [Name] VARCHAR(20) NOT NULL UNIQUE,
        	 CONSTRAINT [Pk_MarketPlace.Category] PRIMARY KEY CLUSTERED (Id ASC));
  END
GO

IF EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'Category' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
        INSERT INTO [MarketPlace].[Category] ( Name) VALUES
        ('Guitars'),('Piano/keys'),('Drums and Percussion'),
        ('Wind instruments'),('Indian instruments'),('Violin'),
        ('Studio and recording'),('Accessories'),('Amplifiers') ,('Pitched Percussion'),('Others');
  END
GO
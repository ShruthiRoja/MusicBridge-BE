IF NOT EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'Condition' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
         CREATE TABLE [MarketPlace].[Condition](
            [Id] INT IDENTITY (1, 1) NOT NULL,
            [Name] VARCHAR(20) NOT NULL UNIQUE,
        	 CONSTRAINT [Pk_MarketPlace.Condition] PRIMARY KEY CLUSTERED (Id ASC));
  END
GO

IF EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'Condition' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
        INSERT INTO [MarketPlace].[Condition] ( Name) VALUES
        ('Brand new'),('Box opened - unused'),('Lightly used'),('Used');
  END
GO
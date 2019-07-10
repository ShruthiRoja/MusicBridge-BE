IF NOT EXISTS ( select * from [INFORMATION_SCHEMA].[COLUMNS] where
  TABLE_NAME = 'Product' and
  TABLE_SCHEMA = 'MarketPlace' )
  begin
         CREATE TABLE [MarketPlace].[Product](
            [Id]                UNIQUEIDENTIFIER    NOT NULL ,
            [Name]              NVARCHAR(MAX)       NOT NULL ,
            [CategoryId]        INT                 NOT NULL ,
            [Price]             DECIMAL(8,2)        NOT NULL ,
            [Brand]             NVARCHAR(MAX)       NOT NULL ,
            [Description]       NVARCHAR(MAX)      NOT NULL ,
            [SubCategoryId]     INT                 NOT NULL ,
            [ConditionId]       INT                   NOT NULL ,
            [ImagesPath]        NVARCHAR(MAX)       NOT NULL ,
            [VideosPath]        NVARCHAR(MAX)       NULL ,
            [CreatedBy]         UNIQUEIDENTIFIER    NOT NULL ,
            [CreatedDT]         DATETIME           NOT NULL ,
            [UpdatedBy]         UNIQUEIDENTIFIER    NULL ,
            [UpdatedDT]         DATETIME           NULL ,
            [Version]           BIGINT              NOT NULL ,
        	 CONSTRAINT [Pk_MarketPlace.Product] PRIMARY KEY CLUSTERED (Id ASC));
  END
GO

IF NOT EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'SubCategory' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
        CREATE TABLE [MarketPlace].[SubCategory](
                     [Id] INT IDENTITY (1, 1) NOT NULL,
					 [Name] VARCHAR(40) NOT NULL,
					 [CategoryId] INT NOT NULL
					 CONSTRAINT [FK_MarketPlaceCategoryId] FOREIGN KEY (CategoryId)
                     REFERENCES [MarketPlace].[Category] ([Id]) ON DELETE CASCADE,
					 CONSTRAINT [Pk_MarketPlace.SubCategory] PRIMARY KEY CLUSTERED (Id ASC)
            );
  END
GO

IF EXISTS ( SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE
  TABLE_NAME = 'SubCategory' AND
  TABLE_SCHEMA = 'MarketPlace' )
  BEGIN
        INSERT INTO [MarketPlace].[SubCategory] ( Name ,CategoryId ) VALUES
        ('Acoustic guitars',1 ),('Electric guitars',1),('Classical guitars',1),('Bass guitars',1) ,
		('Pianos',2),('Keys',2),
        ('Acoustic drums',3),('Snare drums',3),('Electric drums',3),('Cajons',3),('Djembes',3),('Other percussions',3),
		('Clarinets',4),('Flutes',4),('Harmonica',4),('Recorders',4),('Saxophones',4),('Trombones',4),('Trumpets',4),
		('Didgeridoo',4),('Others',4),
		('Tabla',5),('Mridangam',5),('Dholak',5),('Kanjira',5),('Ghatam',5),('Harmonium',5),
		('Tanpura',5),('Veena',5),('Sitar',5),('Shruthi box',5),('Others',5),
		('Cello',6),('Viola',6),('Violin',6),('Others',6),
		('Audio interface',7),('Monitors and speakers',7),('Headphones',7),('MIDI keyboards',7),
		('Mixers',7),('Pre-amps',7),('Others',7),
		('Guitar accessories',8),('Drums and percussions accessories',8),('Keyboard accessories',8),('Others',8),
		('Guitars amplifiers',9),('Bass amplifiers',9),('Keyboard amplifiers',9),('Others',9),
		('Hand pans',10);
  END
GO
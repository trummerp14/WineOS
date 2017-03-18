USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Fertigungsanlage]    Script Date: 18.03.2017 15:58:13 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Fertigungsanlage](
	[ID] [int] NOT NULL,
	[Bezeichnung] [nvarchar](max) NOT NULL,
	[Volumen] [int] NOT NULL,
	[Bestandteile] [nvarchar](max) NULL,
 CONSTRAINT [PK_Fertigungsanlage] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE [dbo].[Fertigungsanlage]  WITH CHECK ADD  CONSTRAINT [FK_Fertigungsanlage_Weingut] FOREIGN KEY([ID])
REFERENCES [dbo].[Weingut] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Fertigungsanlage] CHECK CONSTRAINT [FK_Fertigungsanlage_Weingut]
GO



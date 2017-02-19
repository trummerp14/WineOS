USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Haendler_Weingut]    Script Date: 16.01.2017 21:28:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Haendler_Weingut](
	[ID_Flasche_Haendler] [int] NOT NULL,
	[FK_Flasche] [int] NOT NULL,
	[FK_Haendler] [int] NOT NULL,
 CONSTRAINT [PK_Haendler_Weingut] PRIMARY KEY CLUSTERED 
(
	[ID_Flasche_Haendler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Haendler_Weingut]  WITH CHECK ADD  CONSTRAINT [FK_Flasche] FOREIGN KEY([FK_Flasche])
REFERENCES [dbo].[Flasche] ([ID])
GO

ALTER TABLE [dbo].[Haendler_Weingut] CHECK CONSTRAINT [FK_Flasche]
GO

ALTER TABLE [dbo].[Haendler_Weingut]  WITH CHECK ADD  CONSTRAINT [FK_Haendler] FOREIGN KEY([ID_Flasche_Haendler])
REFERENCES [dbo].[Haendler_Weingut] ([ID_Flasche_Haendler])
GO

ALTER TABLE [dbo].[Haendler_Weingut] CHECK CONSTRAINT [FK_Haendler]
GO



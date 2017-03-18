USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Flasche_Haendler]    Script Date: 18.03.2017 15:57:23 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Flasche_Haendler](
	[ID_Flasche_Haendler] [int] IDENTITY(1,1) NOT NULL,
	[FK_Flasche] [int] NOT NULL,
	[FK_Haendler] [int] NOT NULL,
 CONSTRAINT [PK_Haendler_Weingut] PRIMARY KEY CLUSTERED 
(
	[ID_Flasche_Haendler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Flasche_Haendler]  WITH CHECK ADD  CONSTRAINT [FK_Flasche] FOREIGN KEY([FK_Flasche])
REFERENCES [dbo].[Flasche] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Flasche_Haendler] CHECK CONSTRAINT [FK_Flasche]
GO

ALTER TABLE [dbo].[Flasche_Haendler]  WITH CHECK ADD  CONSTRAINT [FK_Haendler] FOREIGN KEY([FK_Haendler])
REFERENCES [dbo].[Haendler] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Flasche_Haendler] CHECK CONSTRAINT [FK_Haendler]
GO



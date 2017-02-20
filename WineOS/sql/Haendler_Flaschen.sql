USE [WineOS]
GO

/****** Object:  Table [dbo].[Haendler_Flaschen]    Script Date: 19.02.2017 19:32:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Haendler_Flaschen](
	[FK_Flasche] [int] NOT NULL,
	[FK_Haendler] [int] NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Haendler_Flaschen]  WITH CHECK ADD  CONSTRAINT [FK_Flasche] FOREIGN KEY([FK_Flasche])
REFERENCES [dbo].[Flasche] ([ID])
GO

ALTER TABLE [dbo].[Haendler_Flaschen] CHECK CONSTRAINT [FK_Flasche]
GO


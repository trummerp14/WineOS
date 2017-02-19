USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Weingut]    Script Date: 16.01.2017 21:28:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Weingut](
	[ID] [int] NOT NULL,
	[Bezug_Nur_Durchhaendler] [int] NULL,
	[Oeffnungszeit_Von] [date] NULL,
	[Oeffnungszeit_Bis] [date] NULL,
	[Verkostungsmoeglichkeit] [int] NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Weingut]  WITH CHECK ADD  CONSTRAINT [Weingut_Charge] FOREIGN KEY([ID])
REFERENCES [dbo].[Charge] ([ID])
GO

ALTER TABLE [dbo].[Weingut] CHECK CONSTRAINT [Weingut_Charge]
GO



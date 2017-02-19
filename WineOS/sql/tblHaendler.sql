USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Haendler]    Script Date: 16.01.2017 21:28:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Haendler](
	[ID] [int] NOT NULL,
	[Name] [varchar](max) NULL,
	[Oeffnungszeit_Von] [date] NULL,
	[Oeffnungszeit_Bis] [date] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO



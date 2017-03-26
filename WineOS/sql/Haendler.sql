USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Haendler]    Script Date: 26.03.2017 16:47:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Haendler](
	[ID] [int] NOT NULL,
	[Adresse] [varchar](max) NULL,
	[Name] [varchar](max) NULL,
	[Ort] [varchar](max) NULL,
	[PLZ] [int] NULL,
 CONSTRAINT [PK_Haendler] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO



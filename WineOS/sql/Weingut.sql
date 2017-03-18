USE [WINE_OS]
GO

/****** Object:  Table [dbo].[Weingut]    Script Date: 18.03.2017 15:56:52 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Weingut](
	[ID] [int] NOT NULL,
	[Adresse] [nvarchar](max) NULL,
	[Ort] [nvarchar](max) NULL,
	[Plz] [nvarchar](max) NULL,
 CONSTRAINT [PK_Weingut] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO



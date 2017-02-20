USE [WineOS]
GO

/****** Object:  Table [dbo].[Weingut]    Script Date: 16.01.2017 21:28:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Weingut](
	[ID] [int] NOT NULL,
	[Adresse] [varchar](max) NULL,
	[Ort] [varchar](max) NULL,
	[PLZ] [int] NULL,
	[Charge_ID] [int] NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Weingut]  WITH CHECK ADD  CONSTRAINT [Weingut_Charge] FOREIGN KEY([ID])
REFERENCES [dbo].[Charge] ([ID])
GO

ALTER TABLE [dbo].[Weingut] CHECK CONSTRAINT [Weingut_Charge]
GO



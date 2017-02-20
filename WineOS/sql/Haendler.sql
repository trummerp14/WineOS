USE [WineOS]
GO

/****** Object:  Table [dbo].[Weingut]    Script Date: 19.02.2017 19:30:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Weingut](
	[id] [int] NOT NULL,
	[Adresse] [varchar](max) NULL,
	[Ort] [varchar](max) NULL,
	[PLZ] [int] NULL,
	[Charge_id] [int] NOT NULL,
 CONSTRAINT [PK_Weingut] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Weingut]  WITH CHECK ADD  CONSTRAINT [Weingut_Charge] FOREIGN KEY([id])
REFERENCES [dbo].[Charge] ([ID])
GO

ALTER TABLE [dbo].[Weingut] CHECK CONSTRAINT [Weingut_Charge]
GO



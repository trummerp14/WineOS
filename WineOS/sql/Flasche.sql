USE [WineOS]
GO

/****** Object:  Table [dbo].[Flasche]    Script Date: 19.02.2017 19:30:16 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Flasche](
	[ID] [int] NOT NULL,
	[Bezeichnung] [varchar](max) NOT NULL,
	[Fuellmenge] [float] NOT NULL,
	[Stueck] [int] NOT NULL,
	[Auspraegung] [varchar](max) NULL,
	[FK_Charge] [int] NOT NULL,
 CONSTRAINT [PK_Flasche] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Flasche]  WITH CHECK ADD  CONSTRAINT [FK_Flasche_Flasche] FOREIGN KEY([ID])
REFERENCES [dbo].[Flasche] ([ID])
GO

ALTER TABLE [dbo].[Flasche] CHECK CONSTRAINT [FK_Flasche_Flasche]
GO

ALTER TABLE [dbo].[Flasche]  WITH CHECK ADD  CONSTRAINT [Flasche_Charge] FOREIGN KEY([FK_Charge])
REFERENCES [dbo].[Charge] ([ID])
GO

ALTER TABLE [dbo].[Flasche] CHECK CONSTRAINT [Flasche_Charge]
GO



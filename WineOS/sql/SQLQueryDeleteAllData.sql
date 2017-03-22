Delete FROM dbo.Flasche_Haendler Where ID_Flasche_Haendler is Not NULL;
Delete FROM dbo.Charge Where ID is Not NULL;
Delete FROM dbo.Haendler Where ID is Not NULL;
Delete FROM dbo.Weingut Where ID is Not NULL;
Delete FROM dbo.Fertigungsanlage Where ID is Not NULL;
Delete FROM dbo.Flasche Where ID is NOT NULL;
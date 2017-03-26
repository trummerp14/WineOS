USE WINE_OS
GO

INSERT INTO Weingut(ID, Plz, Ort, Adresse)
VALUES 
(1, 8080, 'Graz', 'Grazerstraﬂe'),
(2, 8081, 'Feldbach', 'Feldbacherstraﬂe'),
(3, 8082, 'Kapfenberg', 'Kapfenbergerstraﬂe'),
(4, 8083, 'Leibnitz', 'Weinstraﬂe'),
(5, 8083, 'Bruck', 'Bruckerstraﬂe')

GO

INSERT INTO Charge(ID, FK_Weingut, Bezeichnung)
VALUES 
(1, 1, 'Charge_Gruener_Veltnliner'),
(2, 1, 'Charge_002_Gelber_Veltnliner'),
(3, 1, 'Charge_003_Muskatela'),
(4, 2, 'Charge_001_Tramina'),
(5, 2, 'Charge_001_Muskatela'),
(6, 3, 'Charge_001_Tramina'),
(7, 4, 'Charge_001_Eiswein'),
(8, 4, 'Charge_001_Gelber_Veltliner'),
(9, 4, 'Charge_001_Gruener_Veltliner'),
(10, 5, 'Charge_001_Gewuerz_Traminer')

GO

INSERT INTO Fertigungsanlage(ID, FK_Weingut, Bezeichnung, Bestandteile, Volumen)
VALUES 
(1, 1, 'Presse', 'Standart', 100),
(2, 2, 'Multipresse', 'Modifiziert', 200),
(3, 3, 'Einfachpresse', 'Kleine Ausf¸hrung', 50),
(4, 4, 'Glycolextractor', 'Standart', 25),
(5, 5, 'Glycolbeimenger', 'Modifiziert sehr klein', 10)

GO

INSERT INTO Flasche(ID, FK_Charge, Bezeichnung, Auspraegung, Fuellmenge, Stueck)
VALUES
(1, 1, 'Gruener Veltliner', 'Normal', 0.75, 3),
(2, 1, 'Gruener Veltliner', 'Normal', 1.0, 2),
(3, 2, 'Gelber Veltliner', 'Normal', 0.75, 3),
(4, 2, 'Gelber Veltliner', 'Normal', 1.0, 3),
(5, 2, 'Gelber Veltliner', 'Normal', 1.5, 3),
(6, 3, 'Muskatela', 'Normal', 0.75, 3),
(7, 4, 'Tramina', 'Normal', 0.75, 3),
(8, 5, 'Muskatela', 'Normal', 1.0, 7),
(9, 6, 'Tramina', 'Normal', 1.0, 3),
(10, 7, 'Eiswein', 'Normal', 0.75, 3),
(11, 8, 'Gelber Veltliner', 'Normal', 0.75, 3),
(12, 9, 'Gruener Veltliner', 'Normal', 0.75, 3),
(13, 10, 'Gewuerz Tramina', 'Normal', 0.75, 3),
(14, 4, 'Tramina', 'Normal', 0.75, 3),
(15, 5, 'Muskatela', 'Normal', 0.75, 3),
(16, 3, 'Muskatela', 'Normal', 0.75, 3),
(17, 9, 'Gruener Veltliner', 'Normal', 0.75, 3),
(18, 8, 'Gelber Veltliner', 'Normal', 0.75, 3),
(19, 8, 'Gelber Veltliner', 'Normal', 0.75, 3),
(20, 7, 'Eiswein', 'Normal', 0.75, 3)

GO

INSERT INTO Haendler(ID, PLZ, Name, Adresse, Ort)
VALUES 
(1, 7752, 'Wein und Co', 'Weingasse', 'Weinitzen'),
(2, 7820, 'Co und Wein', 'Trumptower', 'Feldkirchen'),
(3, 8080, 'Steyer Weine', 'Hugogasse', 'Leoben'),
(4, 2350, 'Ing.Hofer Weine', 'Hoferstraﬂe', 'Bruck'),
(5, 4750, 'Trummer Weine', 'Trummerstraﬂe', 'Graz')


INSERT INTO Flasche_Haendler(FK_Flasche, FK_Haendler)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 3),
(12, 3),
(13, 3),
(14, 3),
(15, 3),
(16, 4),
(17, 4),
(18, 5),
(19, 5),
(20, 5)


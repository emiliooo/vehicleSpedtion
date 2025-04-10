CREATE TABLE vehicles (
                          Vehicle_ID INT AUTO_INCREMENT PRIMARY KEY,
                          Brand VARCHAR(50),
                          Model VARCHAR(50),
                          Registration_Number VARCHAR(20),
                          Production_Year YEAR,
                          Vehicle_Type VARCHAR(50),
                          Technical_Condition VARCHAR(100),
                          Last_Inspection_Date DATE
);
############################################################################################

CREATE TABLE drivers (
                         Driver_ID INT AUTO_INCREMENT PRIMARY KEY,
                         Full_Name VARCHAR(100),
                         License_Number VARCHAR(50),
                         License_Category VARCHAR(20),
                         Contact_Phone VARCHAR(15),
                         Incident_History TEXT
);

#######################################################################################
CREATE TABLE routes (
                        Route_ID INT AUTO_INCREMENT PRIMARY KEY,
                        Vehicle_ID INT,
                        Driver_ID INT,
                        Start_Point VARCHAR(100),
                        End_Point VARCHAR(100),
                        Start_Date DATE,
                        End_Date DATE,
                        Distance_Traveled FLOAT,
                        FOREIGN KEY (Vehicle_ID) REFERENCES vehicles(Vehicle_ID),
                        FOREIGN KEY (Driver_ID) REFERENCES drivers(Driver_ID)
);
######################################################################################
CREATE TABLE maintenance_and_repairs (
                                         Repair_ID INT AUTO_INCREMENT PRIMARY KEY,
                                         Vehicle_ID INT,
                                         Repair_Type VARCHAR(100),
                                         Repair_Date DATE,
                                         Repair_Cost FLOAT,
                                         Problem_Description TEXT,
                                         FOREIGN KEY (Vehicle_ID) REFERENCES vehicles(Vehicle_ID)
);

INSERT INTO maintenance_and_repairs (Vehicle_ID, Repair_Type, Repair_Date, Repair_Cost, Problem_Description)
VALUES
    (1, 'Wymiana oleju', '2025-03-01', 250.00, 'Regularna wymiana oleju silnikowego'),
    (2, 'Naprawa układu hamulcowego', '2025-02-15', 1200.00, 'Wymiana klocków hamulcowych i tarcz'),
    (3, 'Wymiana opon', '2025-03-10', 800.00, 'Zakup i montaż nowych opon zimowych'),
    (4, 'Naprawa układu chłodzenia', '2025-02-25', 950.00, 'Usunięcie wycieku płynu chłodniczego'),
    (5, 'Diagnostyka silnika', '2025-03-05', 300.00, 'Sprawdzenie błędów w pracy silnika'),
    (1, 'Wymiana akumulatora', '2025-03-20', 450.00, 'Zainstalowano nowy akumulator'),
    (2, 'Regeneracja turbosprężarki', '2025-01-30', 1800.00, 'Naprawa turbosprężarki po awarii'),
    (3, 'Naprawa zawieszenia', '2025-03-12', 1100.00, 'Wymiana amortyzatorów i sprężyn'),
    (4, 'Czyszczenie układu paliwowego', '2025-02-28', 400.00, 'Usunięcie zanieczyszczeń z układu paliwowego'),
    (5, 'Naprawa klimatyzacji', '2025-03-15', 600.00, 'Uzupełnienie czynnika chłodniczego i naprawa kompresora');
########################################################################################################################################################################################
CREATE TABLE fuel_consumption (
                                  Fuel_Consumption_ID INT AUTO_INCREMENT PRIMARY KEY,
                                  Vehicle_ID INT,
                                  Refuel_Date DATE,
                                  Fuel_Amount FLOAT,
                                  Fuel_Cost FLOAT,
                                  Average_Consumption FLOAT,
                                  FOREIGN KEY (Vehicle_ID) REFERENCES vehicles(Vehicle_ID)
);

INSERT INTO fuel_consumption (Vehicle_ID, Refuel_Date, Fuel_Amount, Fuel_Cost, Average_Consumption) VALUES
                                                                                                        (1, '2025-03-01', 40.5, 180.75, 8.0),
                                                                                                        (2, '2025-03-02', 50.0, 225.00, 7.5),
                                                                                                        (1, '2025-03-10', 35.0, 157.50, 7.0),
                                                                                                        (3, '2025-03-15', 60.0, 270.00, 9.0),
                                                                                                        (2, '2025-03-20', 45.0, 202.50, 7.2);

#####################################################################################################################################################
CREATE TABLE telemetry (
                           Telemetry_Data_ID INT AUTO_INCREMENT PRIMARY KEY,
                           Vehicle_ID INT,
                           Average_Speed FLOAT,
                           Max_Speed FLOAT,
                           Engine_Working_Time TIME,
                           GPS_Location VARCHAR(255),
                           FOREIGN KEY (Vehicle_ID) REFERENCES vehicles(Vehicle_ID)
);

INSERT INTO telemetry (Vehicle_ID, Average_Speed, Max_Speed, Engine_Working_Time, GPS_Location)
VALUES
    (1, 65.4, 110.8, '02:15:30', 'Warszawa, ul. Marszałkowska 45'),
    (2, 72.3, 125.6, '01:40:12', 'Kraków, ul. Długa 22'),
    (3, 58.9, 98.2, '03:10:05', 'Wrocław, ul. Legnicka 12'),
    (1, 70.2, 130.0, '00:55:45', 'Łódź, al. Piłsudskiego 100'),
    (2, 60.0, 100.5, '01:20:00', 'Gdańsk, ul. Grunwaldzka 82');

#############################################################################################################################################################################################################
CREATE TABLE road_events (
                             Event_ID INT AUTO_INCREMENT PRIMARY KEY,
                             Vehicle_ID INT,
                             Driver_ID INT,
                             Event_Date DATE,
                             Event_Description TEXT,
                             Event_Costs FLOAT,
                             FOREIGN KEY (Vehicle_ID) REFERENCES vehicles(Vehicle_ID),
                             FOREIGN KEY (Driver_ID) REFERENCES drivers(Driver_ID)
);
INSERT INTO road_events (Vehicle_ID, Driver_ID, Event_Date, Event_Description, Event_Costs)
VALUES
    (1, 1, '2024-10-12', 'Kolizja z dzikiem na trasie S8. Uszkodzony zderzak i reflektor.', 2500.00),
    (2, 2, '2024-11-03', 'Awaria silnika w trakcie jazdy. Holowanie do serwisu.', 1800.50),
    (3, 3, '2025-01-18', 'Stłuczka na parkingu. Zarysowany bok pojazdu.', 600.00),
    (1, 2, '2025-02-25', 'Zgłoszenie kradzieży lusterek w Warszawie.', 450.75),
    (2, 1, '2025-03-10', 'Wymiana pękniętej opony po najechaniu na krawężnik.', 320.00);
############################################################################################################################################################################################################################

CREATE TABLE system_users (
                              User_ID INT AUTO_INCREMENT PRIMARY KEY,
                              Full_Name VARCHAR(100),
                              User_Role VARCHAR(50),
                              Username VARCHAR(50),
                              Password VARCHAR(255)
);

INSERT INTO system_users (Full_Name, User_Role, Username, Password)
VALUES
    ('Anna Kowalska', 'Administrator', 'akowalska', 'Hasło123!'),
    ('Marek Nowak', 'Kierowca', 'mnowak', 'BezpieczneHaslo!'),
    ('Joanna Wiśniewska', 'Dyspozytor', 'jwisniewska', 'Dyspozycja2025'),
    ('Tomasz Zieliński', 'Mechanik', 'tzielinski', 'Mechanik#2024'),
    ('Katarzyna Mazur', 'Kierowca', 'kmazur', 'KasiaPass99');

################################################################################################################################################################
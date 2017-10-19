SELECT CONCAT(Person.FirstName, ' ', Person.LastName) AS CustomerName, Room.RoomNumber
FROM Room
INNER JOIN Room_Reservation
ON Room.RoomID = Room_Reservation.RoomID
INNER JOIN Reservation
ON Room_Reservation.ReservationID = Reservation.ReservationID
INNER JOIN Customer
ON Reservation.CustomerID = Customer.CustomerID
INNER JOIN Person
ON Customer.PersonID = Person.PersonID
WHERE Reservation.EndDate is NOT NULL;


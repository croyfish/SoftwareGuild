#Tables required: Reservation, Customer, Room_Reservation

SELECT Customer.CustomerID, Reservation.ReservationID, RoomID, StartDate DATETIME, EndDate Datetime, Cancelled
From Customer
INNER JOIN Reservation
ON Customer.CustomerID = Reservation.CustomerID
INNER JOIN Room_Reservation
ON Reservation.ReservationID = Room_Reservation.ReservationID
WHERE Room_Reservation.Cancelled = 1;
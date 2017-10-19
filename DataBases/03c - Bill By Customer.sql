SELECT Reservation.CustomerID, BillDetail.BillDetailName, BillDetail.Charge
FROM Room
INNER JOIN Room_Reservation
ON Room.RoomID = Room_Reservation.RoomID
INNER JOIN Reservation
ON Room_Reservation.ReservationID = Reservation.ReservationID
INNER JOIN Bill
ON Reservation.ReservationID = Bill.ReservationID
INNER JOIN BillDetail
ON Bill.BillID = BillDetail.BillID
Where Reservation.CustomerID = 1;

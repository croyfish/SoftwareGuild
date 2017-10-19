SELECT Reservation.CustomerID, BillDetail.BillDetailName, BillDetail.Charge, PromotionCode.PromotionCodeName, PromotionCode.DollarsOff, PromotionCode.Percent

FROM Room
INNER JOIN Room_Reservation
ON Room.RoomID = Room_Reservation.RoomID
INNER JOIN Reservation
ON Room_Reservation.ReservationID = Reservation.ReservationID
INNER JOIN Bill
ON Reservation.ReservationID = Bill.ReservationID
INNER JOIN BillDetail
ON Bill.BillID = BillDetail.BillID
INNER JOIN PromotionCode_Reservation
ON Reservation.ReservationID = PromotionCode_Reservation.ReservationID
INNER JOIN PromotionCode
ON PromotionCode_Reservation.PromotionCodeID = PromotionCode.PromotionCodeID
Where Reservation.CustomerID = 1;

#Let's Understand this Before TMW
SELECT *
FROM room_reservation
JOIN
(
    SELECT Room_Reservation.ReservationID
	FROM Room_Reservation
	Group by ReservationID
	Having count(Room_Reservation.ReservationID) >= 2
) T2
ON room_reservation.ReservationID = T2.ReservationID;
SELECT rv.ReservationID, r.RoomNumber, rat.roomaddontypename, ra.dateordered 
#want to keep this as small as possible to keep data entry as small as possible -- if we can show these columns together, we can show them together in the context of a bill (detail)....
From Reservation rv
INNER JOIN Room_Reservation rr
ON rv.ReservationID = rr.ReservationID
Inner join Room r 
ON r.RoomID = rr.RoomID
INNER JOIN RoomAddOn ra
ON rr.Room_ReservationID = ra.Room_ReservationID
Inner join RoomAddOnType rat ON rat.RoomAddOnTypeID = ra.RoomAddOnTypeID;

/*
FROM RoomAddOn ra
Inner join RoomAddOnType rat ON rat.RoomAddOnTypeID = ra.RoomAddOnTypeID
Inner join Room_Reservation rr ON rr.Room_ReservationID = ra.Room_ReservationID #maybe this doesn't make sense -- what if the reservationw as cancelled? why would you have add on info on a reservation anyway? what if you changed your mind after
#you got to the hotel? Or are we just using the reservation to find the bill? If a bill does exist for that reservation, its ok. just need to write data that meets this condition.
Inner join Room r ON r.RoomID = rr.RoomID;
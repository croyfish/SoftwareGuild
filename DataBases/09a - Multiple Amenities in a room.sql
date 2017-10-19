#2. show that a room can have multiple amenities, some of the same type #need to consider date? no, since RoomAmenity is tied to RoomType -- see RoomType_RoomAmenity bridge table

#show a room with all the amenities it contains

SELECT r.BranchID, r.RoomNumber, rt_ram.Quantity, ramt.RoomAmenityTypeName
FROM Room r
Inner join RoomType rt ON rt.RoomTypeID = r.RoomTypeID
INNER join RoomType_RoomAmenity rt_ram ON rt_ram.RoomTypeID = rt.RoomTypeID
INNER join RoomAmenity ram ON ram.RoomAmenityID = rt_ram.RoomAmenityID
Inner join RoomAmenityType ramt ON ramt.RoomAmenityTypeID = ram.RoomAmenityTypeID
WHERE rt_ram.Quantity > 1;
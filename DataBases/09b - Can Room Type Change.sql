#3. show that room type can change

#a room with its type, then the same room with a differnet type

SELECT r.BranchID, r.RoomNumber, rt.StartDate, IFNULL(rt.EndDate, 'Present') AS 'EndDate', rt.RoomTypeName
From Room r
inner join RoomType rt ON r.RoomTypeID = rt.RoomTypeID;
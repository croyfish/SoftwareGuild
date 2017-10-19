SELECT RoomType.RoomTypeName, RoomRate.StartDate, RoomRate.EndDate, RoomRate.Rate
FROM RoomType
INNER JOIN RoomRate
ON RoomRate.RoomTypeID = RoomType.RoomTypeID;
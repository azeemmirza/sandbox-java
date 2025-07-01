# LAB 07

## Simple Queries

### 6.7 List full details of all hotels
```sql
SELECT * FROM Hotel;
```

### 6.8 List full details of all hotels in London
```sql
SELECT * FROM Hotel
WHERE city = 'London';
```

### 6.9 List names and addresses of guests living in London, alphabetically by name
```sql
SELECT guestName, guestAddress FROM Guest
WHERE guestAddress LIKE '%London%'
ORDER BY guestName ASC;
```

### 6.10 List all double or family rooms with a price below £40.00 per night, in ascending order of price
```sql
SELECT * FROM Room
WHERE type IN ('Double', 'Family') AND price < 40.00
ORDER BY price ASC;
```

### 6.11 List the bookings for which no dateTo has been specified
```sql
SELECT * FROM Booking
WHERE dateTo IS NULL;
```

## Aggregate Functions

### 6.12 How many hotels are there?
```sql
SELECT COUNT(*) AS hotel_count FROM Hotel;
```

### 6.13 What is the average price of a room?
```sql
SELECT AVG(price) AS average_price FROM Room;
```

### 6.14 What is the total revenue per night from all double rooms?
```sql
SELECT SUM(price) AS total_revenue_per_night
FROM Room
WHERE type = 'Double';
```

### 6.15 How many different guests have made bookings for August?
```sql
SELECT COUNT(DISTINCT guestNo) AS august_guest_count
FROM Booking
WHERE MONTH(dateFrom) = 8;
```

## Subqueries and Joins

### 6.16 List the price and type of all rooms at the Grosvenor Hotel
```sql
SELECT Room.price, Room.type
FROM Room
JOIN Hotel ON Room.hotelNo = Hotel.hotelNo
WHERE Hotel.hotelName = 'Grosvenor Hotel';
```

### 6.17 List all guests currently staying at the Grosvenor Hotel
```sql
SELECT Guest.*
FROM Booking
JOIN Guest ON Booking.guestNo = Guest.guestNo
JOIN Hotel ON Booking.hotelNo = Hotel.hotelNo
WHERE Hotel.hotelName = 'Grosvenor Hotel'
  AND Booking.dateTo IS NULL;
```

### 6.18 List the details of all rooms at the Grosvenor Hotel, including the name of the guest staying in the room, if occupied
```sql
SELECT r.*, g.guestName
FROM Room r
JOIN Hotel h ON r.hotelNo = h.hotelNo
LEFT JOIN Booking b ON r.roomNo = b.roomNo AND r.hotelNo = b.hotelNo AND b.dateTo IS NULL
LEFT JOIN Guest g ON b.guestNo = g.guestNo
WHERE h.hotelName = 'Grosvenor Hotel';
```

### 6.19 What is the total income from bookings for the Grosvenor Hotel today?
```sql
SELECT SUM(r.price) AS today_income
FROM Booking b
JOIN Room r ON b.roomNo = r.roomNo AND b.hotelNo = r.hotelNo
JOIN Hotel h ON b.hotelNo = h.hotelNo
WHERE h.hotelName = 'Grosvenor Hotel'
  AND '2025-06-30' BETWEEN b.dateFrom AND IFNULL(b.dateTo, '9999-12-31');
```

## Grouping

### 6.22 List the number of rooms in each hotel
```sql
SELECT hotelNo, COUNT(*) AS room_count
FROM Room
GROUP BY hotelNo;
```

### 6.23 List the number of rooms in each hotel in London
```sql
SELECT r.hotelNo, COUNT(*) AS room_count
FROM Room r
JOIN Hotel h ON r.hotelNo = h.hotelNo
WHERE h.city = 'London'
GROUP BY r.hotelNo;
```

### 6.24 What is the average number of bookings for each hotel in August?
```sql
SELECT hotelNo, COUNT(*) / COUNT(DISTINCT guestNo) AS avg_bookings
FROM Booking
WHERE MONTH(dateFrom) = 8
GROUP BY hotelNo;
```

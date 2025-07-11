-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS logs WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', 'replication_factor' : '3' };

-- Create a table
CREATE TABLE IF NOT EXISTS logs.user_activity (
id UUID,
user_id UUID,
activity_id UUID,
activity_type text,
timestamp timestamp,
PRIMARY KEY (user_id, timestamp))
WITH CLUSTERING ORDER BY (timestamp DESC);

-- Insert some data
INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (6800c126-57ea-410e-92b7-457038bb7cf8, a2ff5078-05b8-4d75-b230-1d956081bd06, c0a431c0-32cd-4c21-8fca-39401a83ef0d, 'login', toTimeStamp(now()));

INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (e61305ad-3195-47fd-a7be-2def690c6578, 08c5926d-b187-421f-9e7a-860a8f9978d5, 9e982fed-0694-4a89-97d7-1237dd9c0b97, 'view', toTimeStamp(now()));

INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (6454f61b-e0f3-457e-9eb8-1c6792d7389d, 84f5fc9d-e2fc-4e59-a735-64e8cd78f6cb, 2c0cece2-81fa-45bb-83fc-4c66d6f7bb2f, 'purchase', '2025-07-10 22:05:01.902000+0000');

INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (567fc25a-d3fd-4384-8e77-08b66017a16e, 1d4e47b1-7c93-43be-9a1a-818a5eaa8dc7, b5129429-68ef-4fa1-86b3-c0889e3722cb, 'logout', '2025-07-08 14:55:48.001000+0000');

INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (c818e7cc-54c9-40be-9f1a-d32a712332f8, a8d57691-1d05-4ba6-bcdb-cf78ce55c2f4, 75d0a989-407b-4525-95df-0e2346759217, 'pdp', '2025-07-09 20:30:18.415000+0000');

INSERT INTO logs.user_activity (id, user_id, activity_id, activity_type, timestamp)
VALUES (172b0271-da08-42a2-9eb2-792c6060359f, bc06c516-7fed-4b36-9407-bf5effcc3bc5, 8a529444-5b60-412b-9bec-c8322d3c4330, 'checkout', '2025-07-06 20:11:28.311000+0000');

-- Get all logs (optional)
SELECT * FROM logs.user_activity;
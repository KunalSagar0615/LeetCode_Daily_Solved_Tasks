select user_id,CONCAT(UPPER(LEFT(name, 1)),
        LOWER(SUBSTRING(name, 2))) as name
from Users
order by user_id;
# Write your MySQL query statement below
SELECT
    customer_id,
    COUNT(*) AS total_orders,
    ROUND(
        100 * SUM(
            TIME(order_timestamp) BETWEEN '11:00:00' AND '14:00:00'
            OR TIME(order_timestamp) BETWEEN '18:00:00' AND '21:00:00'
        ) / COUNT(*)
    ) AS peak_hour_percentage,
    ROUND(AVG(order_rating), 2) AS average_rating
FROM restaurant_orders
GROUP BY customer_id
HAVING total_orders >= 3
   AND peak_hour_percentage >= 60
   AND average_rating >= 4.0
   AND SUM(order_rating IS NOT NULL) / COUNT(*) >= 0.5
ORDER BY average_rating DESC, customer_id DESC;
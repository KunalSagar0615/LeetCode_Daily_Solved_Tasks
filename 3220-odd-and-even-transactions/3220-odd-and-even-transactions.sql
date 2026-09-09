# Write your MySQL query statement below
Select transaction_date, 
sum(if(amount%2 = 0, 0, amount)) AS odd_sum, 
sum(if(amount%2 = 0, amount, 0)) AS even_sum 
From transactions group by transaction_date
order by transaction_date; 
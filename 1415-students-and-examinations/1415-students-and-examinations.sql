# Write your MySQL query statement below

select s.student_id, s.student_name,su.subject_name , count(e.subject_name) as attended_exams
from Students s 
CROSS JOIN Subjects su 
LEFT JOIN Examinations e
ON s.student_id = e.student_id AND su.subject_name = e.subject_name

Group BY s.student_id , s.student_name,su.subject_name
order BY student_id, subject_name
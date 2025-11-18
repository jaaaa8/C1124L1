use b1_insert_data_std_management;

-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
SELECT Address, COUNT(id) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
SELECT S.id, s.name, AVG(Mark)
FROM Student S join Mark M on S.id = M.student_id
GROUP BY S.id, S.name;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.id,S.name, AVG(Mark)
FROM Student S join Mark M on S.id = M.student_id
GROUP BY S.id, S.name
HAVING AVG(Mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT S.id, S.name, AVG(Mark)
FROM Student S join Mark M on S.id = M.student_id
GROUP BY S.id, S.name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.student_id);




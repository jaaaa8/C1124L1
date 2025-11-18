use b1_insert_data_std_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select* from Subject order by credit desc limit 1;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.id, s.name, s.status, max(m.mark) as max_mark
from Subject s
join Mark m on m.sub_id = s. id
group by s.id, s.name, s.credit, s.status
having max(m.mark) = (select max(mark) from Mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select st.id,
       st.name,
       st.address,
       st.phone,
       st.status,
       st.class_id,
       ifnull(avg(m.mark), 'chua co diem') as avg_mark
from Student st
left join Mark m on st.id = m.student_id
group by st.id, st.name, st.address, st.phone, st.status, st.class_id
order by avg_mark desc;
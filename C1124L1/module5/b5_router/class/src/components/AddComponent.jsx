import {ErrorMessage, Field, Form, Formik} from "formik";
import {useEffect, useState} from "react";
import {getAllClass} from "../service/classService.js";
import {Button} from "react-bootstrap";
import {addNew, getAll} from "../service/studentService.js";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import * as Yup from "yup";

const AddComponent = () => {
    const [classList , setClassList] = useState([]);
    const navigate = useNavigate();
    const [newStudent, setNewStudent] =useState({
        id: "",
        name: "",
        gender:"",
        class: ""
    })
    useEffect(() => {
       const fetData = async ()=>{
           let list = await getAllClass();
           setClassList(list);
       };
       fetData();

    }, []);
    const handleAdd= (value)=>{
        console.log("--------ADD--------")
          value ={
              ...value,
              class: JSON.parse(value.class)
          }
        const fetData = async ()=>{
            let isSuccess = await addNew(value);
            if (isSuccess){
                toast.success("Thêm mới thành công");
            }else {
                toast.error("Thất bại");
            }
            navigate(("/student"));
        };
        fetData();
    }
    const validate = Yup.object({
        id: Yup.number().required("Id không để trống")
            .min(1,"không được số âm"),
        name:Yup.string().required("nhập tên")
            .matches(/^[A-Z][a-z]*(\s[A-Z][a-z]*)+$/,"Phải đúng định dạng"),
        class: Yup.string().required("Yêu cầu nhập tên lớp")
    })

    return (
         <>
            <h1>Thêm mới sinh viên</h1>
            <Formik initialValues={newStudent} onSubmit={handleAdd} validationSchema={validate}>
                <Form>
                    <div>
                        <label>ID</label>
                        <Field type ="text" name = "id"/>
                        <ErrorMessage name={'id'} component={'div'}/>
                    </div>
                    <div>
                        <label>Name</label>
                        <Field type ="text" name = "name"/>
                        <ErrorMessage name={'name'} component={'div'}/>
                    </div>
                    <div>
                        <label>Gender</label>
                        <Field type ="radio" name = "gender" value = "false"/> Nữ
                        <Field type ="radio" name = "gender" value = "true"/> Nam
                    </div>
                    <div>
                        <label>Class name</label>
                        <Field as= "select" name = "class">
                           <option value="">----Chọn----</option>
                            {
                                classList.map(cls =>(
                                    <option key={cls.id} value={JSON.stringify(cls)}>{cls.name}</option>
                                ))
                            }
                        </Field>
                        <ErrorMessage name={'class'} component={'div'}/>
                    </div>
                    <div>
                        <Button type={'submit'}>Lưu</Button>
                    </div>

                </Form>
            </Formik>
        </>
    )
}
export default AddComponent;
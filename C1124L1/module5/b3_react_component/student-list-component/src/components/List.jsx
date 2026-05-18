import React from 'react';
import { getAll } from '../service/StundentService';
import '../App.css'

class ListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [],
        }
    }

     componentDidMount() {
         console.log("--------didMount------");
         this.setState({
             studentList: [...getAll()]
         })
     }

    render() {
        return (
            <>
                <h1>Danh sách sinh viên</h1>
                <table className={'table table-bordered table-double-border'}>
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Tuổi</th>
                            <th>Địa chỉ</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.studentList.map((student, i) =>
                            <tr key={student.id}>
                                <td>{i + 1}</td>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.age}</td>
                                <td>{student.address}</td>
                            </tr>)}
                    </tbody>
                </table>
            </>

        );
    }
}

export default ListComponent;
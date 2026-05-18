import React from 'react';
import { getAll, add } from '../service/todoService';
import '../App.css'; 

class ListComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            todoList: [],
            item: ''
        };
    }

    componentDidMount() {
        console.log("--------didMount------");
        this.setState({
            todoList: [...getAll()]
        });
    }

    handleChange = (event) => {
        this.setState({ item: event.target.value });
    };

    handleAddItem = () => {
        const { item } = this.state;
        if (item.trim() !== "") {
            add(item.trim());
            this.setState({
                todoList: [...getAll()],
                item: "" 
            });
        }
    };

    render() {
        return (
            <>
                <h1>TODO List</h1>
                
                <div style={{ marginBottom: '15px' }}>
                    <input
                        type="text"
                        value={this.state.item}
                        onChange={this.handleChange}
                        placeholder="Enter new task..."
                    />
                    <button onClick={this.handleAddItem}>Add</button>
                </div>

                <table className={'table table-bordered table-double-border'}>
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>NAME</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.todoList.map((todo, i) =>
                            <tr key={todo.id}>
                                <td>{i + 1}</td>
                                <td>{todo.id}</td>
                                <td>{todo.name}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </>
        );
    }
}

export default ListComponent;
import React from 'react';
import { calculate } from '../service/calculatorService';

class Calculator extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            num1: '',
            num2: '',
            operator: '',
            result: null
        };
    }

    render() {
        return (
            <div className='trideptrai'>
                <input
                    type="number"
                    value={this.state.num1}
                    onChange={(e) => this.setState({ num1: e.target.value })}
                    placeholder="Nhập số thứ nhất"
                />

                <select value={this.state.operator} onChange={(e) => this.setState({ operator: e.target.value })}>
                    <option value="">Chọn phép tính</option>
                    <option value="add">+</option>
                    <option value="subtract">-</option>
                    <option value="multiply">×</option>
                    <option value="divide">÷</option>
                </select>

                <input
                    type="number"
                    value={this.state.num2}
                    onChange={(e) => this.setState({ num2: e.target.value })}
                    placeholder="Nhập số thứ hai"
                />


                <button onClick={() => this.setState({ result: calculate(this.state.num1, this.state.num2, this.state.operator) })}>
                    Calculate
                </button>

                <h2>Result: {this.state.result}</h2>
            </div>
        );
    }
}

export default Calculator;

const counter1 = ({ handleIncrement }) => {
    return (
        <div>
            <h1>Counter 1</h1>
            <button className={"btn btn-sm btn-success"} onClick={() => handleIncrement(1)}>
                Increment 1
            </button>
        </div>
    );
}
export default counter1;
const counter2 = ({ handleIncrement }) => {
    return (
        <div>
            <h1>Counter 2</h1>
            <button className={"btn btn-sm btn-success"} onClick={() => handleIncrement(2)}>
                Increment 2
            </button>
        </div>
    );
}
export default counter2;
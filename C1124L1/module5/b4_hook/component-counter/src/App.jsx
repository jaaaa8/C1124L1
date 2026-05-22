import { useState } from 'react'
import './App.css'
import Counter1 from "./components/Counter1.jsx";
import Counter2 from "./components/Counter2.jsx";


function App() {
  const [count, setCount] = useState(0);

  const handleIncrement = (amount) => {
    setCount(prevCount => prevCount + amount);
  }

  return (
    <>
      <Counter1 handleIncrement={handleIncrement} />
      <Counter2 handleIncrement={handleIncrement} />
      <h1>Counter: {count}</h1>
    </>
  )
}

export default App

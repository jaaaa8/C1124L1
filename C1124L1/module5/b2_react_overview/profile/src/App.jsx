
import './App.css'

function App() {

  return (
    <>
      <div className="container">
        <div className="card">
          <div className="card--header" />
          <img
            className="avatar"
            src="https://images4.alphacoders.com/105/thumb-1920-1057973.jpg"
            alt="avatar"
          />
          <div className="card--body">
            <div>
              <p className="text-header">Kaneki Ken</p>
              <p className="text-sub">
                What wrong isn't me, what wrong is the world.
              </p>
              <button className="btn third">FOLLOW</button>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default App

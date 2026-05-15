import React from 'react'

import './App.css'

function App() {
  const l1 = React.createElement('li', null, 'Đà Nẵng')
  const l2 = React.createElement('li', null, 'Hồ Chí Minh')
  const l3 = React.createElement('li', null, 'Hà Nội')
  const ul = React.createElement('ul', null, l1, l2, l3)
  const h1 = React.createElement('h1', null, 'Vice City')
  const div = React.createElement('div', { className: 'a' }, h1, ul)
  

  return (
    div
  )
}

export default App

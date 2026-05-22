import ListStudent from './components/ListStudent'
import './App.css'
import {getAll} from "./service/studentService.js";
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.js"
import React from 'react';

function App() {

  return (
    <>
      <ListStudent />
    </>
  )
}

export default App

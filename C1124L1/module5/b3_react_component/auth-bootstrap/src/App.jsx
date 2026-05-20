import React, { Component } from 'react'
import Home from './components/Home';
import './App.css';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      form: { email: '', password: '', isRemember: false },
      isValid: false,
      isLoggedIn: false
    }
  }

  handleChange = (event) => {
    this.setState((state) => {
      const { form } = state
      form[event.target.name] = event.target.value
      return { form }
    }, () => this.checkValidForm())
  }

  handleChangeCheckbox = () => {
    this.setState((state) => {
      const { form } = state
      form.isRemember = !form.isRemember
      return { form }
    }, () => this.checkValidForm())
  }

  checkValidForm = () => {
    const { email, password } = this.state.form
    const value = email && password
    this.setState({ isValid: value })
  }

  handleSubmit = () => {
    if (this.state.isValid) {
      this.setState({ isLoggedIn: true })
    }
  }

  handleLogOut = () => {
    this.setState({ isLoggedIn: false })
  }

  render() {
    const { isLoggedIn, form } = this.state
    if (isLoggedIn) return (<Home onLogOut={this.handleLogOut} />)

    return (
      <div className="container-fluid d-flex justify-content-center align-items-center text-center min-vh-100 bg-light">
        
        <div className="form-signin bg-white p-4 p-md-5 rounded-4 shadow" style={{ maxWidth: '400px', width: '100%' }}>
          <form>
            <img className="mb-4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/2023_Facebook_icon.svg/1280px-2023_Facebook_icon.svg.png?utm_source=vi.wikipedia.org&utm_campaign=index&utm_content=thumbnail" alt="" width="72" height="57" />
            <h1 className="h3 mb-4 fw-normal">Please sign in</h1>

            <div className="form-floating">
              <input
                id="floatingEmail"
                className="form-control email"
                type="email"
                name="email"
                placeholder="name@example.com"
                value={form.email}
                onChange={this.handleChange}
              />
              <label htmlFor="floatingEmail">Email address</label>
            </div>
            <div className="form-floating mt-3">
              <input
                id="floatingPassword"
                className="form-control password"
                type="password"
                name="password"
                placeholder="Password"
                value={form.password}
                onChange={this.handleChange}
              />
              <label htmlFor="floatingPassword">Password</label>
            </div>

            <div className="checkbox mb-4 mt-3 text-start">
              <label>
                <input
                  type="checkbox"
                  className="me-2"
                  checked={form.isRemember}
                  onChange={this.handleChangeCheckbox}
                /> Remember me
              </label>
            </div>

            <button className="w-100 btn btn-lg btn-primary fw-bold" type="button" onClick={this.handleSubmit}>Sign in</button>
            <p className="mt-5 mb-0 text-muted">© 2017–2026</p>
          </form>
        </div>
      </div>
    )
  }
}


export default App

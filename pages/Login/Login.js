import React, { Component } from 'react'
import {connect} from "react-redux"

class Login extends Component {
    constructor(props){
        super(props);
        this.state ={
            usernameValue: "",
            passwordValue: ""
        }

        this.handleUsername = this.handleUsername.bind(this)
        this.handlePassword = this.handlePassword.bind(this)

        
    }

    // HandeOnchange
    handleUsername = (event) => {
        this.setState({ usernameValue: event.target.value })
    }
    handlePassword = (event) => {
        this.setState({ passwordValue: event.target.value })
    }

    // HandleSubmit
    handleSubmit = (event) => {
        event.preventDefault();

        this.submitLogin(
            this.state.usernameValue,
            this.state.passwordValue
        )
    }

    submitLogin=(inputUsername, inputPassword)=>{
        const loginUser = {
            username: inputUsername,
            password: inputPassword,
        }

        this.fetchDataLogin("/login", "post", loginUser)
    }

    fetchDataLogin = (url, inputMethod, dataToObj) => {
        try{
            const option = {
                method: inputMethod,
                mode: "cors",
                headers:{ 
                    "Content-Type": "application/json",
                    "Access-Control-Allow-Origin" : "*", 
                    "Access-Control-Allow-Credentials" : true 
                },
                body: JSON.stringify(dataToObj)
            }
    
            fetch("http://localhost:8887/web/hotel" + url, option)
                .then(response => response.json())
                .then(async json => {
                    console.log("Json : ", json);
                    this.props.fetchDataLogin(json)
                })
        } catch (error) {
            if (error instanceof fetch.AbortError) {
                console.log("Request Hotel Data Was Aborted")
            }
        }
    }

    render(){
        return(
            <div>
                <h1>Login User</h1>
                <form onSubmit={this.handleSubmit}>
                    <h3>Username</h3>
                    <input 
                    type="text"
                    placeholder="Masukkan Username"
                    value={this.state.usernameValue}
                    onChange={this.handleUsername}
                    />
                    <h3>Password</h3>
                    <input 
                    type="password"
                    placeholder="Masukkan Password"
                    value={this.state.passwordValue}
                    onChange={this.handlePassword}
                    />
                    <input type="Submit" value="Login" />
                </form>
            </div>
        )
    }
}

const mapDispatchToProps = dispatch => {
    return{
        fetchDataLogin: (user) => dispatch({
            type: "LOGIN_OK",
            data: user
        })
    }
}
  

export default connect(null, mapDispatchToProps)(Login);
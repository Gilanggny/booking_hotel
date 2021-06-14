import React, { Component } from 'react'

class Registration extends Component {
    constructor(props){
        super(props);
        this.state = {
            name: "",
            phone: "",
            address: "",
            username: "",
            password: ""
        }

        // Handle Change
        this.handleChangeName = this.handleChangeName.bind(this)
        this.handleChangePhone = this.handleChangePhone.bind(this)
        this.handleChangeAlamat = this.handleChangeAlamat.bind(this)
        this.handleChangeUsername = this.handleChangeUsername.bind(this)
        this.handleChangePassword = this.handleChangePassword.bind(this)

        // Handle Submit
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    // Handle Change
    handleChangeName = event => {
        this.setState({name:event.target.value})
    }
    handleChangePhone = event => {
        this.setState({phone:event.target.value})
    }
    handleChangeAlamat = event => {
        this.setState({address:event.target.value})
    }
    handleChangeUsername = event => {
        this.setState({username:event.target.value})
    }
    handleChangePassword = event => {
        this.setState({password:event.target.value})
    }

    // Handle Submit
    handleSubmit = event => {
        event.preventDefault();

        this.SubmitRegisterFunction(
            this.state.name,
            this.state.phone,
            this.state.address,
            this.state.username,
            this.state.password
        )
    }

    // Submit Function
    SubmitRegisterFunction(inputName, inputPhone, 
        inputAddress, inputUsername, inputPassword){
        const newUser = {
            name: inputName,
            phone: inputPhone,
            address: inputAddress,
            username: inputUsername,
            password:inputPassword
        }

        this.fetchDataRegister("/register", "post", newUser);
    }

    fetchDataRegister = (url, inputMethod, dataToObj) => {
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
                    // this.props.fetchDataLogin(json)
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
                <h1></h1>
                <hr />
                <form className="userInput" 
                onSubmit={this.handleSubmit}
                >
                    <div className="row-input">
                        <span className="label">Masukan Nama Lengkap: </span>
                        <input type="text" 
                        name="nameValue" 
                        placeholder="Nama Lengkap Pengguna"
                        onChange={this.handleChangeName}
                        value={this.state.name}
                        />
                    </div>

                    <div className="row-input">
                        <span className="label">Masukkan Nomor Telepon : </span>
                        <input type="text" 
                        name="phoneValue" 
                        placeholder="Nomor Telepon"
                        onChange={this.handleChangePhone}
                        value={this.state.phone}
                        />
                    </div>

                    <div className="row-input">
                        <span className="label">Masukkan Alamat : </span>
                        <input type="text" 
                        name="addressValue" 
                        placeholder="Alamat Pengguna" 
                        onChange={this.handleChangeAlamat}
                        value={this.state.address}
                        />
                    </div>

                    <div className="row-input">
                        <span className="label">Masukkan Username : </span>
                        <input type="text" 
                        name="usernameValue" 
                        placeholder="Input Username"
                        onChange={this.handleChangeUsername}
                        value={this.state.username}
                        />
                    </div>

                    <div className="row-input">
                        <span className="label">Masukkan Password : </span>
                        <input type="text" 
                        name="passwordValue" 
                        placeholder="Input Password"
                        onChange={this.handleChangePassword}
                        value={this.state.password}
                        />
                    </div>

                    <div className="row-button">
                        <input type="submit" value="Register" />
                    </div>
                </form>
            </div>
        )
    }
}

export default Registration;
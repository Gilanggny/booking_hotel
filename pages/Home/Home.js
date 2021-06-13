import React, { Component } from 'react'
import BuildTable from './BuildTable'
import './Home.css'

class Home extends Component {
    render(){
        return(
            <div>
                <h1>Pesan Hotel Sekarang</h1>
                <hr />
                <BuildTable />
            </div>
        )
    }
}

export default Home;
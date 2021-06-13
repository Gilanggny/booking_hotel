import React, { Component } from 'react'
import GlobalStyle from './globalStyles';
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import { Navbar} from './components';
import { connect } from "react-redux"

class App extends Component {
  constructor(props){
    super(props);
    this.state ={}
  }

  fetchDataHotel = (url, inputMethod) => {
    try{
        const option = {
            method: inputMethod,
            mode: "cors",
            headers:{ 
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin" : "*", 
                "Access-Control-Allow-Credentials" : true 
            }
        }

        fetch("http://localhost:8887/web/hotel" + url, option)
            .then(response => response.json())
            .then(async json => {
                console.log("Json : ", json);
                
                const listUser = await json.map(hotel => {
                    return {
                        id: hotel.id,
                        hotelName: hotel.name,
                        kota: hotel.kota,
                        jumlahKamar: hotel.kamar,
                        terpakai: hotel.address,
                        tersedia: hotel.tersedia
                    }
                })
                console.log(listUser)
                this.props.HotelFetchData(listUser);
            })
    } catch (error) {
        if (error instanceof fetch.AbortError) {
            console.log("Request Hotel Data Was Aborted")
        }
    }
  }

  componentDidMount(){
    this.fetchDataHotel("/list", "get")
  }

  render(){
    return(
      <Router>
        <GlobalStyle />
        <Navbar />
      </Router>
    )
  }
}

const mapDispatchToProps = dispatch => {
  return{
    HotelFetchData: (hotel) => dispatch({
        type: "FETCH_DATA_HOTEL",
        data: hotel
    })
  }
}

export default connect(null, mapDispatchToProps)(App);

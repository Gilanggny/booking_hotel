import React, { Component } from 'react'

class Product extends Component {
  render(){
    return (
      <div
        style={{
          display: 'flex',
          justifyContent: 'center',
          alignItems: 'center',
          height: '90vh'
        }}
      >
        <h1>Ini Products</h1>
      </div>
    )
  }
}

export default Product;

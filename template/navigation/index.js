import React, { Component } from 'react';
import "./navigation.css"

class Nav extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="nav">
                {this.props.children}
            </div>
        );
    }
}

export default Nav;
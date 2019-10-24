import React from 'react';
import {Navbar, Nav, NavItem} from 'reactstrap';
import {NavLink} from "react-router-dom";

function Header(props) {
    console.log(props);
    return(
        <React.Fragment>
            <Navbar dark>
                <div className="container">
                    <NavLink className="mr-auto" to="/home">
                        <img src="assets/logos/dominos_logo.png" alt="Domino's Pizza"/>
                    </NavLink>
                    <Nav navbar>
                        <NavItem>
                            {props.data == null || props.data === 0 ? <NavLink className="nav-link">
                                                        <div style={{border: "1px", borderStyle: "solid", borderColor: "#cdcdcd", borderRadius: "30px", paddingLeft: "15px", paddingRight: "15px"}}>
                                                            <img style={{paddingTop: "10px", paddingBottom: "10px", marginRight: "10px"}}
                                                                 src="assets/logos/basket_logo.png" alt="Basket"/>
                                                            <a style={{fontWeight: "bold", color: "#ffffff"}}>{props.data}</a>
                                                        </div>
                                                  </NavLink>
                                                : <NavLink className="nav-link" to="/basket">
                                                        <div style={{border: "1px", borderStyle: "solid", borderColor: "#cdcdcd", borderRadius: "30px", paddingLeft: "15px", paddingRight: "15px"}}>
                                                            <img style={{paddingTop: "10px", paddingBottom: "10px", marginRight: "10px"}}
                                                                 src="assets/logos/basket_logo.png" alt="Basket"/>
                                                            <a style={{fontWeight: "bold", color: "#ffffff"}}>{props.data}</a>
                                                        </div>
                                                  </NavLink>
                            }
                        </NavItem>
                    </Nav>
                </div>
            </Navbar>
        </React.Fragment>
    )
}

export default Header;
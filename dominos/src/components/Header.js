import React from 'react';
import {Navbar, NavbarBrand, Nav, NavItem} from 'reactstrap';
import {NavLink} from "react-router-dom";

function Header(props) {
    return(
        <React.Fragment>
            <Navbar dark>
                <div className="container">
                    <NavbarBrand className="mr-auto" href="/">
                        <img src="assets/logos/dominos_logo.png" alt="Domino's Pizza"/>
                    </NavbarBrand>
                    <Nav navbar>
                        <NavItem>
                            <NavLink className="nav-link" to="/basket">
                                <div style={{border: "1px", borderStyle: "solid", borderColor: "#cdcdcd", borderRadius: "30px", paddingLeft: "15px", paddingRight: "15px"}}>
                                    <img style={{paddingTop: "10px", paddingBottom: "10px", marginRight: "10px"}}
                                         src="assets/logos/basket_logo.png" alt="Basket"/>
                                    <a style={{fontWeight: "bold", color: "#ffffff"}}>{props.data}</a>
                                </div>
                            </NavLink>
                        </NavItem>
                    </Nav>
                </div>
            </Navbar>
        </React.Fragment>
    )
}

export default Header;
import React, {Component} from 'react';
import Home from './Home';
import Basket from './Basket';
import Header from '../components/Header';
import Footer from '../components/Footer';
import {DISHES} from '../utils/dishes';
import {Switch, Route, Redirect} from 'react-router-dom';

export default class Main extends Component {
    constructor(props){
        super(props);
        this.state = {
            dishes: DISHES
        };
    }

    render() {
        const HomePage = () => {
            return(
                <Home
                    dish={this.state.dishes.filter((dish) => dish.featured)[0]}
                />
            );
        };

        const BasketPage = () => {
            return(
                <Basket
                    dish={this.state.dishes.filter((dish) => dish.featured)[0]}
                />
            );
        };


        return (
            <div>
                <Header data={this.state.dishes.length}/>
                <Switch>
                    <Route path="/home" component={HomePage}/>
                    <Route path="/basket" component={BasketPage}/>
                    <Redirect to="/home"/>
                </Switch>
                <Footer/>
            </div>
        );
    }
}

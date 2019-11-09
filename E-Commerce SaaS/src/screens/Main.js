import React, {Component} from 'react';
import Home from './Home';
import Basket from './Basket';
import Header from '../components/Header';
import Footer from '../components/Footer';
import {Switch, Route, Redirect} from 'react-router-dom';
import { connect } from 'react-redux';

const mapStateToProps = state => {
    return {
        dishes: state.dishes
    }
};

class Main extends Component {
    constructor(props){
        super(props);
        this.state = {
            basketCount: 0,
            basketItems: []
        };
    }

    addToBasket = (count, items) => {
        this.setState({basketCount: count});
        this.setState({basketItems: items});
        console.log(this.state.basketItems);
    };

    removeFromBasket = (count, items) => {
        this.setState({basketCount: count});
        this.setState({basketItems: items});
    };

    render() {
        const HomePage = () => {
            return(
                <Home
                    dish={this.props.dishes.dishes.filter((dish) => dish.featured)[0]}
                    basketCount={this.state.basketCount}
                    basketItems={this.state.basketItems}
                    addToBasket={this.addToBasket}
                />
            );
        };

        const BasketPage = () => {
            return(
                <Basket
                    item={this.state.basketItems}
                    basketCount={this.state.basketCount}
                    basketItems={this.state.basketItems}
                    removeFromBasket={this.removeFromBasket}
                />
            );
        };


        return (
            <div>
                <Header data={this.state.basketCount}/>
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

export default connect(mapStateToProps)(Main);

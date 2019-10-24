import React, {Component} from 'react';
import {Jumbotron} from 'reactstrap';
import RenderCard from '../components/Card/HomeCard';

export default class Home extends Component {
    constructor(props){
        super(props);
        this.state = {};
    }

    render() {
        const { dish, basketCount, basketItems, addToBasket } = this.props;
        return(
            <div>
                <Jumbotron>
                    <div className="container">
                        <div className="row row-header">
                            <div className="col-12 col-sm-6">
                                <div className="pizza_logo">
                                    <img src="assets/logos/pizza_logo_1.png" alt="Pizza"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </Jumbotron>
                <div style={{background: "#ffebe8"}}>
                    <div className="container" style={{paddingTop: "40px", paddingBottom: "40px", border: "1px", borderStyle: "solid", borderColor: "#cdcdcd"}}>
                        <div className="card_area">
                            <div style={{paddingLeft: "50px"}}>
                                <p style={{fontSize: "30px", fontWeight: "bold", color: "#747474"}}>Pizzalar</p>
                            </div>
                            <div style={{paddingLeft: "15px", paddingRight: "15px", marginBottom: "25px"}}>
                                <div className="row align-items-start">
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                </div>
                            </div>
                            <div style={{paddingLeft: "15px", paddingRight: "15px"}}>
                                <div className="row align-items-start">
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                    <div className="col-12 col-md m-1">
                                        <RenderCard
                                            dish={dish}
                                            basketCount={basketCount}
                                            basketItems={basketItems}
                                            addToBasket={addToBasket}
                                        />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}




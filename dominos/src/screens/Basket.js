import React from 'react';
import RenderCard from '../components/Card/BasketCard';

const Basket = (props) => {
    console.log(props)
    return (
        <div style={{background: "#ffebe8"}}>
            <div className="container" style={{
                paddingTop: "40px",
                paddingBottom: "500px",
                border: "1px",
                borderStyle: "solid",
                borderColor: "#cdcdcd"
            }}>
                <div className="card_area">
                    <div style={{paddingLeft: "50px"}}>
                        <p style={{fontSize: "30px", fontWeight: "bold", color: "#747474"}}>Sepet</p>
                    </div>
                    <div style={{paddingLeft: "15px", paddingRight: "15px", marginBottom: "25px"}}>
                        <div className="row align-items-start">
                            <div className="col-12 col-md m-1">
                                <RenderCard item={props.item} />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Basket;

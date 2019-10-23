import React from 'react';
import {Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle} from "reactstrap";

let basketCount = 0;
let basketItem;
let basketItems = [];

function RenderCard({dish, addToBasket}) {
    return(
        <Card style={{width: "270px", height: "380px", borderRadius: "30px"}}>
            <CardBody style={{height: "50%", background: "#a9a9a9", borderTopLeftRadius: "30px", borderTopRightRadius: "30px"}}>
                <CardImg style={{width: "146px", height: "148px", display: "block", marginLeft: "auto", marginRight: "auto"}}
                         src={dish.image}
                         alt={dish.name} />
            </CardBody>
            <CardBody style={{height: "50%", paddingLeft: "25px", paddingRight: "25px", paddingBottom: "30px"}}>
                <CardTitle style={{fontSize: "21px", fontWeight: "bold"}}>{dish.name}</CardTitle>
                {dish.designation ? <CardSubtitle>{dish.designation}</CardSubtitle> : null}
                <CardText style={{fontSize: "14px"}}>{dish.description}</CardText>
                <CardTitle style={{fontSize: "21px", fontWeight: "bold", color: "orange"}}>
                    {dish.price} TL <Button onClick={() => {
                        basketCount++;
                        basketItem = {
                            name: dish.name,
                            price: dish.price
                        };
                        basketItems.push(basketItem);
                        addToBasket(basketCount, basketItems)
                }} color="success" style={{float: "right"}}>Sepete Ekle</Button>
                </CardTitle>
            </CardBody>
        </Card>
    );
}


export default RenderCard;
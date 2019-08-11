import React from 'react';
import {Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle} from "reactstrap";
import {Link} from "react-router-dom";

function RenderCard({item}) {
    return(
        <Card style={{width: "270px", height: "380px", borderRadius: "30px"}}>
            <CardBody style={{height: "50%", background: "#a9a9a9", borderTopLeftRadius: "30px", borderTopRightRadius: "30px"}}>
                <CardImg style={{width: "146px", height: "148px", display: "block", marginLeft: "auto", marginRight: "auto"}}
                         src={item.image}
                         alt={item.name} />
            </CardBody>
            <CardBody style={{height: "50%", paddingLeft: "25px", paddingRight: "25px", paddingBottom: "30px"}}>
                <CardTitle style={{fontSize: "21px", fontWeight: "bold"}}>{item.name}</CardTitle>
                {item.designation ? <CardSubtitle>{item.designation}</CardSubtitle> : null }
                <CardText style={{fontSize: "14px"}}>{item.description}</CardText>
                <CardTitle style={{fontSize: "21px", fontWeight: "bold", color: "orange"}}>
                    {item.price} TL <Link to="/basket"><Button color="success" style={{float: "right"}}>Sepete Ekle</Button></Link>
                </CardTitle>
            </CardBody>
        </Card>
    );
}


export default RenderCard;
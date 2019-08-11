import React from 'react';
import {Card} from "reactstrap";
import {Link} from "react-router-dom";

function RenderCard({item}) {
    const product = item.name;
    const price = item.price;
    const productCount = item.count;
    const totalPrice = price * productCount;
    return (
        <Card style={{width: "100%", height: "380px", borderRadius: "30px"}}>
            <div style={{paddingLeft: "25px", paddingRight: "25px", paddingTop: "30px", paddingBottom: "30px"}}>
                <div style={{
                    border: "1px",
                    borderStyle: "solid",
                    borderColor: "#cdcdcd",
                    borderRadius: "30px",
                    paddingLeft: "15px",
                    paddingRight: "15px",
                    marginBottom: "15px"
                }}>
                    <a style={{
                        paddingTop: "10px",
                        paddingBottom: "10px",
                        paddingLeft: "10px",
                        marginRight: "10px",
                        fontSize: "14px",
                        fontWeight: "bold"
                    }}>
                        {product} | <a style={{color: "orange"}}>{price} TL</a>
                    </a>
                    <Link to="/home"><img style={{paddingTop: "10px", paddingBottom: "10px", paddingLeft: "630px", marginRight: "10px"}}
                               src="assets/logos/thrash_logo.png" alt="Thrash" onClick={() => {alert("Seçtiğiniz ürün sepetten kaldırıldı.");}}/></Link>
                </div>
                <div style={{
                    border: "1px",
                    borderStyle: "solid",
                    borderColor: "#cdcdcd",
                    borderRadius: "30px",
                    paddingLeft: "15px",
                    paddingRight: "15px",
                    marginBottom: "15px"
                }}>
                    <a style={{
                        paddingTop: "10px",
                        paddingBottom: "10px",
                        paddingLeft: "10px",
                        marginRight: "10px",
                        fontSize: "14px",
                        fontWeight: "bold"
                    }}>
                        {product} | <a style={{color: "orange"}}>{price} TL</a>
                    </a>
                    <Link to="/home"><img style={{paddingTop: "10px", paddingBottom: "10px", paddingLeft: "630px", marginRight: "10px"}}
                                          src="assets/logos/thrash_logo.png" alt="Thrash" onClick={() => {alert("Seçtiğiniz ürün sepetten kaldırıldı.");}}/></Link>
                </div>
                <div style={{
                    border: "1px",
                    borderStyle: "solid",
                    borderColor: "#cdcdcd",
                    borderRadius: "30px",
                    paddingLeft: "15px",
                    paddingRight: "15px"
                }}>
                    <a style={{
                        paddingTop: "10px",
                        paddingBottom: "10px",
                        paddingLeft: "10px",
                        marginRight: "10px",
                        fontSize: "14px",
                        fontWeight: "bold"
                    }}>
                        {product} | <a style={{color: "orange"}}>{price} TL</a>
                    </a>
                    <Link to="/home"><img style={{paddingTop: "10px", paddingBottom: "10px", paddingLeft: "630px", marginRight: "10px"}}
                                          src="assets/logos/thrash_logo.png" alt="Thrash" onClick={() => {alert("Seçtiğiniz ürün sepetten kaldırıldı.");}}/></Link>
                </div>
            </div>
            <div style={{paddingLeft: "25px", paddingRight: "25px", paddingTop: "30px", paddingBottom: "30px"}}>
                <hr/>
                <a style={{fontSize: "21px", fontWeight: "bold"}}>Toplam <a
                    style={{fontSize: "21px", fontWeight: "bold", paddingLeft: "700px"}}>{totalPrice} TL</a></a>
            </div>
        </Card>
    );
}

export default RenderCard;

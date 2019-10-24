import React from 'react';
import {Card} from "reactstrap";
import {Link} from "react-router-dom";


function RenderCard({item, basketCount, basketItems, removeFromBasket}) {
    console.log(item);
    let tempPrice = 0;
    let totalPrice = 0;
    for (let i=0;i<item.length;i++){
        tempPrice = tempPrice + parseInt(item[i].price, 10);
        totalPrice = tempPrice;
    }
    return (
        <div>
            {item.map((item, index) => (
                <Card style={{width: "100%", height: "120px", borderRadius: "30px"}}>
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
                                {item.name} | <a style={{color: "orange"}}>{item.price} TL</a>
                            </a>
                            <Link><img style={{paddingTop: "10px", paddingBottom: "10px", paddingLeft: "630px", marginRight: "10px"}}
                                                  src="assets/logos/thrash_logo.png"
                                                  alt="Thrash"
                                                  onClick={() => {
                                                      alert("Seçtiğiniz ürün sepetten kaldırıldı.");
                                                      basketCount--;
                                                      basketItems.splice(index, 1);
                                                      removeFromBasket(basketCount, basketItems)
                                                  }}
                            /></Link>
                        </div>
                    </div>
                </Card>
            ))}
            <div style={{paddingLeft: "25px", paddingRight: "25px", paddingTop: "30px", paddingBottom: "30px"}}>
                <hr/>
                <a style={{fontSize: "21px", fontWeight: "bold"}}>Toplam <a
                    style={{fontSize: "21px", fontWeight: "bold", paddingLeft: "700px"}}>{totalPrice} TL</a></a>
            </div>
        </div>
    );
}

export default RenderCard;

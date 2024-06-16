package com.example.bazaar

class datamodel {
    var name:String=""
    var price:Double=-1.0
    var disp:String=""
    var img:String=""
    var id=""
    var category=""
    constructor()
    constructor(
        name: String,
        price: Double,
        disp: String,
        img: String,
        id: String,
        category: String
    ) {
        this.name = name
        this.price = price
        this.disp = disp
        this.img = img
        this.id = id
        this.category = category
    }


}
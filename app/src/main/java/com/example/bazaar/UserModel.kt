package com.example.bazaar

class UserModel {
    var fn=""
    var ln=""
    var email=""
    var pass=""
    constructor()
    constructor(fn: String, ln: String, email: String, pass: String) {
        this.fn = fn
        this.ln = ln
        this.email = email
        this.pass = pass
    }

}
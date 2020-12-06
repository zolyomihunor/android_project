package com.example.project_wheretoeat




class User{

    var id: Int = 0
    var name: String = ""
    var address: String = ""
    var phone_number: Int = 0
    var email: String = ""

    constructor(name:String, address: String, phone_number:Int, email:String){
        this.name=name
        this.address=address
        this.phone_number=phone_number
        this.email=email
    }

    constructor(){

    }
}
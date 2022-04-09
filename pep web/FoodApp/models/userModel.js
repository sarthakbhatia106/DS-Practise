const mongoose = require('mongoose');
const emailValidator=require('email-validator');

// let {DB_LINK} = require('../secret');
let {DB_LINK}=require('../secret');

mongoose.connect(DB_LINK, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
}).then(function (db) {
    console.log("db connected");
}).catch(function (e) {
    console.log(e);
})


const userSchema=new mongoose.Schema({
    name:{
        type:String,
        required:true,
    },
    email:{
        type:String,
        required:true,
        unique:true,
        validate: function(){
            return emailValidator.validate(this.email);
        }
    },
    age:{
        type:Number,
    },
    password:{
        type:String,
        minlength:7,
        required:true
    },
    confirmPassword:{
        type:String,
        required:true,
        validate: function(){
            return this.confirmPassword==this.password
        }
    },
    createdAt:{
        type:Date
    },
    token:{
        type:String,
    },
    role:{
        type:String,
        enum:["admin","user","manager"],
        default:"user"
    }

})

userSchema.pre("save",function(){
    //confirmPassword will not be saved in db  
    this.confirmPassword=undefined;
})

//custom finction or middleware
userSchema.methods.resetHandler=function (password,confirmPassword) {
    this.password=password;
    this.confirmPassword=confirmPassword;
    //to avoid reuse of token
    this.token=undefined;
}
const userModel=mongoose.model("userModel",userSchema);

module.exports=userModel;
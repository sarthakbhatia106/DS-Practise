const mongoose = require('mongoose');

let {DB_LINK} = require('../secret');

mongoose.connect(DB_LINK, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
}).then(function (db) {
    console.log("db connected");
}).catch(function (e) {
    console.log(e);
})


const planSchema = mongoose.Schema({
    id: {
        type: Number,
        required: true,
    },
    name: {
        type: String,
        required: true,
    },
    rating: {
        type: String,
    },
    price: {
        type: Number,
        required: true,
    },
    delivery: {
        type: Boolean,
        required: true,
    },
    meals: {
        type: Number,
        required: true
    }, 
    description: {
        type:String
    },
    createdAt:{
        type:Date
    }

})

let planModel=mongoose.model("planModel",planSchema);

module.exports=planModel;


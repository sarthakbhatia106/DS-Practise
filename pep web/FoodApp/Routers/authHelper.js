const jwt=require('jsonwebtoken');
const { JWT_KEY } = require('../secret');

function protectRoute(req,res,next){
    try{
        if(req.cookies.jwt){
            let isVerified=jwt.verify(req.cookies.jwt,JWT_KEY);
            if(isVerified){
                req.uid=isVerified.id;
                next();
            }
        }else{
            res.status(401).json({
                message:"You are not allowed"
            })
        }
    }catch(e){
        return res.status(500).json({
            message:"Server Error "+e
        })
    }
}

module.exports=protectRoute
let planModel = require('../models/planModel');
const userModel = require('../models/userModel');
const express = require('express');
const authRouter = express.Router();
const mongoose = require('mongoose');
const protectRoute = require('./authHelper');
let jwt = require('jsonwebtoken');
const { JWT_KEY } = require("../secret");
let emailSender=require("../externalServices/emailSender");

authRouter
.post("/signup", setCreatedAt, signupUser)
.post("/login", loginUser)
.post("/forgetPassword", forgetPassword)
.post("/resetPassword",resetPassword);

function setCreatedAt(req, res, next) {
    let body = req.body;
    let len = Object.keys(body).length;
    if (len == 0) {
        return res.status(400).json({
            message: "can not create empty user"
        })
    }
    req.body.createdAt = new Date().toISOString();
    next();
}

async function forgetPassword(req, res) {
    let email = req.body.email;

    let seq = (Math.floor(Math.random() * 10000) + 10000).toString().substring(1);

    try {
        if (email) {
            let user = await userModel.updateOne({ email }, { token: seq })
            //send email
            
            await emailSender(seq,email);

            if (user) {
                return res.status(200).json({
                    message: "email sent with token " + seq
                })
            } else {
                return res.status(404).json({
                    message: "user not found"
                })
            }
        }
        else {
            return res.status(400).json({
                message: "kindly enter email"
            })
        }
    } catch (e) {
        return res.status(500).json({
            message: e.message
        })
    }
}

async function resetPassword(req, res) {
    let { token, password, confirmPassword } = req.body;

    try {
        if (token) {

            let user = await userModel.findOne({ token });
            if (user) {
                user.resetHandler(password, confirmPassword);
                await user.save();
                res.status(200).json({
                    message:"user password changed"
                })
            } else {
                return res.status(404).json({
                    message: "incorrect token"
                })
            }
        } else {
            return res.status(404).json({
                message: "user not found"
            })
        }
    }
    catch (e) {
        return res.status(500).json({
            message: e.message
        })
    }
}

async function signupUser(req, res) {
    //email, name, password from frontend
    try {
        let userObj = req.body;
        // console.log("user",req.body);
        let user = await userModel.create(userObj);

        //saving to a local array
        // user.push({
        //     email,password,name
        // })

        res.status(200).json({
            message: "user created",
            createdUser: req.body
        })
    } catch (err) {
        return res.status(400).json({
            message: err.message
        })
    }
}

async function loginUser(req, res) {

    try {
        if (req.body.email) {
            let user = await userModel.findOne({ email: req.body.email })
            if (user) {
                if (user.email == req.body.email && user.password == req.body.password) {

                    let payload = user["_id"]

                    let token = jwt.sign({ id: payload }, JWT_KEY)
                    res.cookie("jwt", token, { httpOnly: true })
                    return res.status(200).json({
                        user,
                        message: "user logged in"
                    })
                } else {
                    return res.status(401).json({
                        message: "Email or password incorrect"
                    })
                }
            } else {
                return res.status(401).json({
                    message: "Email or password incorrect"
                })
            }
        } else {
            return res.status(403).json({
                message: "Email is not present"
            })
        }
    } catch (e) {
        res.status(500).json({
            message: e.message
        })
    }
}


//forget
//reset
//protect route

module.exports = authRouter;

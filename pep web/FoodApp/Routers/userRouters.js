const userModel = require('../models/userModel');
const express = require('express');
const userRouter = express.Router();
const protectRoute = require('./authHelper');


userRouter.route("/").get(getUser);
userRouter.route("/:id").get(protectRoute, authorizeUser(["admin", "manager"]), getUserById).patch(updateUser).delete(protectRoute, authorizeUser(["admin"]), deleteUser);

async function getUser(req, res) {
    try {
        let users = await userModel.find();
        return res.json({
            message: "all users",
            users: users
        })
    } catch (err) {
        return res.status(400).json({
            message: err.message,
        })
    }
}

async function updateUser(req, res) {
    // let a = req.body;
    // for (let key in a) {
    //     obj[key] = a[key];
    // }
    // res.status(200).json(obj);
    try {
        let update = await userModel.findByIdAndUpdate(req.params.id, { name: "sarthak" });
        // console.log(del);
        return res.status(200).json({
            message: "successfully updated"
        })
    } catch (err) {
        console.log(err);
        return res.status(400).json({
            message: err.message
        })
    }
}

async function deleteUser(req, res) {
    // obj = {};
    // res.status(200).json(obj);
    try {
        let del = await userModel.findByIdAndRemove(req.params.id);
        // console.log(del);
    } catch (err) {
        console.log(err);
        return res.status(400).json({
            message: err.message
        })
    }

}

async function getUserById(req, res) {
    // console.log(req.params);
    // res.status(200).send("Hello");
    try {
        let user = await userModel.findById(req.params.id).exec();
        return res.status(200).json({
            message: "found user",
            user: user
        })
    } catch (err) {
        return res.status(400).json({
            message: err.message
        })
    }

}

function authorizeUser(rolesArr) {
    return async function (req, res) {
        let uid = req.uid;
        let { role } = await userModel.findOne(uid);

        let isAuthorized = rolesArr.includes(role);
        if (isAuthorized) {
            next();
        } else {
            res.status(403).json({
                message: "user not authorized contact admin"
            })
        }

    }
}


module.exports = userRouter;
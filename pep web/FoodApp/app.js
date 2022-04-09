const cookieParser = require('cookie-parser');
const express = require('express');

//server: //route -> request -> response/file
//file system:// path -> interact/type -> file/folder
//server init
const app = express();
//post accept
app.use(express.json());
app.use(express.static('public'));
app.use(cookieParser());

const authRouter=require('./Routers/authRouter');
const userRouter=require('./Routers/userRouters');


app.use('/api/user',userRouter);
app.use('/api/auth',authRouter);


//---------------------------Sign up-----------------------------------

//localhost: 8080 
app.listen(8080, function () {
    console.log('Server Started');
})



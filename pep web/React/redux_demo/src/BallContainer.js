import React from 'react'
import { buyBall } from './redux/ball/BallAction'
import {connect} from 'react-redux';

function BallContainer(props) {
    console.log('ball render');
    return (
        <div>
            <h2>Number of Balls- {props.numberOfBalls}</h2>
            <button onClick={props.buyBall}>Buy Ball</button>
        </div>
    )
}

//first method for reading from global state
const mapStateToProps=state=>{
    return{
        numberOfBalls:state.ball.numberOfBalls
    }
}
const mapDispatchToProps=dispatch=>{
    return{
        buyBall:()=>dispatch(buyBall())
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(BallContainer)

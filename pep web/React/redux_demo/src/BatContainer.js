import React,{useState} from 'react'
import {connect} from 'react-redux'
import { buyBat,sellBat } from './redux/bat/BatAction'

function BatContainer(props) {
    const [number, setnumber] = useState(0);
    console.log('Bat render');
    return (
        <div>
            <h2>Number of bats - {props.numberOfBats}</h2>
            <input type='number' value={number} onChange={(e)=>{setnumber(e.target.value)}}/>
            <button onClick={()=>{props.buyBat(number)}}>Buy {number} Bats</button>
            <button onClick={()=>{props.sellBat(number)}}>Sell {number} Bats</button>
        </div>
    )
}

const mapStateToProps=state=>{
    return {
        numberOfBats:state.bat.numberOfBats
    }
}
const mapDispatchToProps=dispatch=>{
    return{
        buyBat: (number)=>dispatch(buyBat(number)),
        sellBat:(number)=>dispatch(sellBat(number))
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(BatContainer)

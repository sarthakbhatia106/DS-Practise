import React,{useState} from 'react'

function Counter() {
    // what we did in class compenents

    // this.state={
    //     count:0
    // }
    // this.setState({
    //     count:1
    // })

    //in fucntional components using hooks
    const [count,setCount]=useState(0);
    const handleInc=()=>{
        setCount(count+1);
    }

    const handleDec=()=>{
        if(count>0){
            setCount(count-1);
        }
    }

    //we pass the initial value of our state to useState as argument

    //useState returns a pair of values i.e a current state and 
    //a fucntion that can be used to change the current state

    return (
        <div>
            <h1>{count}</h1>
            <button onClick={handleInc}>+</button>
            <button onClick={handleDec}>-</button>

        </div>
    )
}

export default Counter

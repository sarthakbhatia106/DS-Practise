import React,{useState,useEffect} from 'react'

function Uewc() {
    const [count,setCount]=useState(0);
    console.log('render');

    //if we use an empty dependency array with useEffect the return statement will not occur 
    //as in that case useEffect willl only run once
    useEffect(()=>{
        console.log('useEffect');
        document.title=`Clicked ${count} times`;
        //clean up
        //it is called before the next useEffect is called
        return ()=>{
            alert(`I will be called before the next useEffect is called ${count}`);
        }
    });
    return (
        <div>
            <p>{count}</p>
            <button onClick={()=>setCount(count+1)}>Click</button>
        </div>
    )
}

export default Uewc

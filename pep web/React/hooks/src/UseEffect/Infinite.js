import React,{useState,useEffect} from 'react';

//this code will occur infinitely if the do so
//if we do not apply an empty dependency array it will run infinitely because
//useEffect will be called everytime any change occurs in the count variable cx without
//dependency array it functions as componentDidMount+componentDidUpdate
//and we are updating the state in useEffect itself, so it is an infinite loop
//when we use empty array as dependency we are using it as componentDidMount only and hence it will
//only run once when the page loads.

function Infinite() {
    const [count,setCount]=useState(0);
    useEffect(()=>{
        console.log('useEffect');
        let num=Math.random()*100;
        setCount(num);
        document.title=count;
    },[])
    return (
        <div>
            <p>Clicked {count} times</p>
            <button onClick={()=>setCount(count+1)}>Click</button>
        </div>
    )
}

export default Infinite

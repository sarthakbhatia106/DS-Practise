import React,{useEffect,useState} from 'react'

//useState ka 1st variation
//no optional dependency array is passed
//it runs after every render
//it acts as componentDidMount+componentDidUpdate

function Ue1() {

    //this will run after the initial loading as well as after every update
    useEffect(()=>{
        console.log('useEffect');
        document.title=`clicked ${count} times`;
    })
    //occurs in every update and while re-rendering
    console.log('render');
    //only occurs in first loading of the page
    const [count,setCount]=useState(0);
    return (
        <div>
            <p>You clicked on the button {count} times</p>
            <button onClick={()=>setCount(count+1)}>Click</button>
        </div>
    )
}

export default Ue1

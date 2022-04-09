import React,{useState,useEffect} from 'react'

//2nd variation
//here the useEffect will function as componentDidMount only
//presence of an empty dependency array

function Ue2() {
    //this will run only once i.e. the first time page loads up
    const [count,setCount]=useState(0);

    //this will also run once but after the renering of page is over
    useEffect(()=>{
        console.log('useEffect');
        document.title=`clicked ${count} times`;
    },[]);

    //runs everytime page renders and re-renders
    console.log('render');
    return (
        <div>
            <p>You clicked the button {count} times</p>
            <button onClick={()=>setCount(count+1)}>Click</button>
        </div>
    )
}

export default Ue2

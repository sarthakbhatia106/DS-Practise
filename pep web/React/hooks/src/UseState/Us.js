import React,{useState} from 'react'

function Us() {
    const [msgObj,setMessage]= useState({message:''});
    const handleChange=(e)=>{
        let val=e.target.value;

        //this wont work as there setMessage did not see any change in the address of the object while rendering
        // msgObj.message=val;
        // setMessage(msgObj);
        // console.log(msgObj);

        //correct way- making different object
        setMessage({...msgObj,message:val});

        //OR

        let obj={message:val}
        setMessage(obj);
    }

    return (
        <div>
            <input type="text" value={msgObj.message} onChange={handleChange}></input>
            <p>{msgObj.message}</p>
        </div>
    )
}

export default Us

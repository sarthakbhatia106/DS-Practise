import React, { Component } from 'react'

export default class Todo extends Component {
    constructor(){
        super();
        this.state={
            tasks:[{id:1, txt:'First Task'},{id:2, txt:'Second Task'},{id:3, txt:'Third Task'}],
            currTask:''
        }
    }
    handleChange=(e)=>{
        let val=e.target.value;
        console.log(val);
        this.setState({
            currTask:val
        })
    }
    handleSubmit=(e)=>{
        // this.state.tasks.push({id:this.state.tasks.length+1,txt:this.state.currTask});
        // this.state.currTask='';
        //this wont work as we need to use setState

        if(this.state.currTask!=''){
            let nta=[...this.state.tasks,{id:this.state.tasks.length+1,txt:this.state.currTask}];
            this.setState({
                tasks:nta,
                currTask:''
            })
        }
    }
    onDelete=(id)=>{
        let nfa=this.state.tasks.filter(function(tobj){
            return tobj.id!=id;
        })
        this.setState({
            tasks:nfa
        })
    }
    render() {
        return (
            <div>
                <div className='input-container'>
                    <input type='text' value={this.state.currTask} onChange={this.handleChange}></input>
                    <button onClick={this.handleSubmit}>Add</button>
                </div>
                <div className='class-list'>
                    <ul>
                        {
                            this.state.tasks.map((tobj)=>{
                                return (
                                    <li key={tobj.txt}>
                                        <h1>{tobj.txt}</h1>
                                        <button onClick={()=>{
                                            this.onDelete(tobj.id);
                                        }}>Delete</button>
                                    </li>
                                )
                            })
                        }
                    </ul>
                </div>
            </div>
        )
    }
}

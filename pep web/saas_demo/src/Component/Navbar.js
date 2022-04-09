import React from 'react'
import '../styles/Navbar.css'
function Navbar() {
    return (
        <div className="navbar">
            <a href="/home">Home</a>
            <a href="/about">About</a>
            <a href="/profile">Profile</a>
            <a href="/contact">Contact</a>
        </div>
    )
}

export default Navbar

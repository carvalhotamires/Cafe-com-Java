import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <nav style={{
            background: '#4A2C2A', // Cor de café escuro
            padding: '15px 30px',
            display: 'flex',
            gap: '30px',
            boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
        }}>
            <Link to="/" style={{ color: 'white', textDecoration: 'none', fontWeight: 'bold', fontSize: '1.1em' }}>
                ☕ Menu
            </Link>
            <Link to="/pedido" style={{ color: 'white', textDecoration: 'none', fontWeight: 'bold', fontSize: '1.1em' }}>
                🛒 Ver Pedido
            </Link>
        </nav>
    );
}

export default Navbar;
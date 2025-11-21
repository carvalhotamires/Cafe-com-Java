import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx'; // Certifique-se de que App está sendo importado
import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <App /> // E que ele está sendo renderizado aqui
    </React.StrictMode>,
)
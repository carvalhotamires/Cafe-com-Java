import React, { useState, useEffect } from 'react';
import api from '../services/api';
import { useOrder } from '../context/OrderContext';
import './Menu.css';

function Menu() {
    const [itens, setItens] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const { addItemToOrder } = useOrder(); // Obtém a função do Context

    useEffect(() => {
        async function carregarMenu() {
            try {
                setLoading(true);
                const response = await api.get('/menu');
                setItens(response.data);
                setError(null);
            } catch (err) {
                console.error("Erro ao carregar o menu:", err);
                setError("Não foi possível carregar o menu. Verifique se o backend Java está rodando na porta 8080.");
                setItens([]);
            } finally {
                setLoading(false);
            }
        }
        carregarMenu();
    }, []);

    const handleAddItem = (item) => {
        addItemToOrder(item);
    };

    if (loading) {
        return <div className="menu-container">Carregando menu...</div>;
    }

    if (error) {
        return <div className="menu-container error">{error}</div>;
    }

    return (
        <div className="menu-container">
            <h1>☕ Cardápio do Café com Java</h1>
            <div className="menu-grid">
                {itens.length > 0 ? (
                    itens.map(item => (
                        // Assumindo que o item tem 'id', 'nome' e 'preco'
                        <div key={item.id} className="menu-item">
                            <h3>{item.nome}</h3>
                            <p className="preco">R$ {item.preco ? item.preco.toFixed(2) : '0.00'}</p>
                            <button
                                className="add-button"
                                onClick={() => handleAddItem(item)}
                            >
                                Adicionar
                            </button>
                        </div>
                    ))
                ) : (
                    <p>Nenhum item no menu. Verifique seu backend.</p>
                )}
            </div>
        </div>
    );
}

export default Menu;
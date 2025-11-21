import React, { createContext, useReducer, useContext } from 'react';
import api from '../services/api';

const initialState = {
    items: [],
    tableId: 1, // Assumindo mesa 1 por padrão para o POST
    total: 0,
};

const orderReducer = (state, action) => {
    switch (action.type) {
        case 'ADD_ITEM': {
            const newItem = action.payload;
            const existingItemIndex = state.items.findIndex(
                (i) => i.item.id === newItem.id
            );

            let updatedItems;

            if (existingItemIndex > -1) {
                // Item já existe: Aumenta a quantidade
                updatedItems = state.items.map((item, index) =>
                    index === existingItemIndex
                        ? { ...item, quantidade: item.quantidade + 1 }
                        : item
                );
            } else {
                // Novo Item: Adiciona com quantidade 1
                updatedItems = [
                    ...state.items,
                    { item: newItem, quantidade: 1, subtotal: newItem.preco },
                ];
            }

            // Recalcula o total
            const newTotal = updatedItems.reduce(
                (sum, current) => sum + current.item.preco * current.quantidade,
                0
            );

            return {
                ...state,
                items: updatedItems,
                total: newTotal,
            };
        }

        case 'CLEAR_ORDER':
            return initialState;

        default:
            return state;
    }
};

export const OrderContext = createContext(initialState);

export const OrderProvider = ({ children }) => {
    const [order, dispatch] = useReducer(orderReducer, initialState);

    const addItemToOrder = (item) => {
        dispatch({ type: 'ADD_ITEM', payload: item });
    };

    const clearOrder = () => {
        dispatch({ type: 'CLEAR_ORDER' });
    };

    const sendOrderToBackend = async () => {
        const orderData = {
            // Adapte esta estrutura de dados exatamente ao JSON que seu backend Java espera
            itens: order.items.map(i => ({
                itemId: i.item.id,
                quantidade: i.quantidade,
            })),
            tableId: order.tableId,
            total: order.total
        };

        try {
            const response = await api.post('/pedidos', orderData);

            alert('✅ Pedido enviado com sucesso! ID: ' + response.data.id);

            clearOrder();
            return response.data;

        } catch (error) {
            console.error("Erro ao enviar o pedido:", error.response ? error.response.data : error.message);
            alert('❌ Erro ao enviar o pedido. Verifique o console.');
            throw error;
        }
    };

    const contextValue = {
        order,
        addItemToOrder,
        clearOrder,
        sendOrderToBackend,
    };

    return (
        <OrderContext.Provider value={contextValue}>
            {children}
        </OrderContext.Provider>
    );
};

export const useOrder = () => {
    return useContext(OrderContext);
};
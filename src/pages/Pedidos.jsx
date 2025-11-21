import React from 'react';
import { useOrder } from '../context/OrderContext';
import { Link } from 'react-router-dom';

function Pedidos() {
    const { order, clearOrder, sendOrderToBackend } = useOrder();

    const handleCheckout = async () => {
        try {
            await sendOrderToBackend();
        } catch (e) {
            // O erro é tratado e exibido no OrderContext
        }
    };

    return (
        <div style={{ padding: '20px' }}>
            <h1>📝 Detalhes do Pedido</h1>

            {order.items.length === 0 ? (
                <>
                    <p>Nenhum item no seu pedido. Adicione algo do menu!</p>
                    <Link to="/" style={{ textDecoration: 'none', color: '#A0522D', fontWeight: 'bold' }}>
                        Ir para o Menu
                    </Link>
                </>
            ) : (
                <>
                    <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '20px' }}>
                        <thead>
                        <tr style={{ borderBottom: '2px solid #ccc' }}>
                            <th style={{ padding: '10px', textAlign: 'left' }}>Item</th>
                            <th style={{ padding: '10px', textAlign: 'right' }}>Preço Unitário</th>
                            <th style={{ padding: '10px', textAlign: 'right' }}>Quantidade</th>
                            <th style={{ padding: '10px', textAlign: 'right' }}>Subtotal</th>
                        </tr>
                        </thead>
                        <tbody>
                        {order.items.map((itemPedido) => (
                            <tr key={itemPedido.item.id} style={{ borderBottom: '1px solid #eee' }}>
                                <td style={{ padding: '10px' }}>{itemPedido.item.nome}</td>
                                <td style={{ padding: '10px', textAlign: 'right' }}>R$ {itemPedido.item.preco.toFixed(2)}</td>
                                <td style={{ padding: '10px', textAlign: 'right' }}>{itemPedido.quantidade}</td>
                                <td style={{ padding: '10px', textAlign: 'right' }}>R$ {(itemPedido.item.preco * itemPedido.quantidade).toFixed(2)}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>

                    <h2 style={{ marginTop: '30px', textAlign: 'right' }}>Total: R$ {order.total.toFixed(2)}</h2>
                    <div style={{ marginTop: '20px', textAlign: 'right' }}>
                        <button
                            onClick={handleCheckout}
                            style={{ padding: '10px', background: 'green', color: 'white', border: 'none', marginRight: '10px', cursor: 'pointer' }}
                        >
                            Finalizar Pedido (Enviar ao Backend Java)
                        </button>
                        <button onClick={clearOrder} style={{ padding: '10px', background: 'red', color: 'white', border: 'none', cursor: 'pointer' }}>
                            Cancelar / Limpar
                        </button>
                    </div>
                </>
            )}
        </div>
    );
}

export default Pedidos;
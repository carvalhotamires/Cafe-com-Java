// src/services/api.js
import axios from 'axios';

const api = axios.create({
    // Mude a URL para onde o seu backend Java estiver rodando
    baseURL: 'http://localhost:8080/api/v1',
});

export default api;
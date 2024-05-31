

// Inserta los datos de productos en una variable JavaScript
const products = [
    { "name": "Adiestramiento Canino Basico Grupal", "description": "6 sesiones", "price": "1800", "imageUrl": "https://www.record.com.mx/sites/default/files/styles/amp-discovery-1200x/public/articulos/2024/02/27/adiestramiento_canino_gratuito.jpg?itok=ezjADweM" },
    { "name": "Adiestramiento Canino Intermedio Grupal", "description": "6 sesiones", "price": "2000", "imageUrl": "https://www.record.com.mx/sites/default/files/styles/amp-discovery-1200x/public/articulos/2024/02/27/adiestramiento_canino_gratuito.jpg?itok=ezjADweM" },
    { "name": "Adiestramiento Canino Basico Privado", "description": "6 sesiones", "price": "2500", "imageUrl": "https://animaltraining.com.mx/wp-content/uploads/2019/11/dog-training-2.jpg" },
    { "name": "Adiestramiento Canino Intermedio Privado", "description": "8 sesiones", "price": "3600", "imageUrl": "https://animaltraining.com.mx/wp-content/uploads/2019/11/dog-training-2.jpg" },
    { "name": "Pet Sitting en centro canino", "description": "2 horas", "price": "350", "imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvLYDsMPxf0e8KF7J23aOAKJ7qjF85BaL2V-eyKRq7_w&s" },
    { "name": "Pet Sitting a domicilio", "description": "2 horas", "price": "500", "imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBqXtQh8y6Ky7GzcZNMecbNqKVa0zO_LMBOZZDMgH-KQ&s" },
    { "name": "Paseo privado", "description": "Paseo privado de una hora", "price": "300", "imageUrl": "https://wala.dog/cdn/shop/articles/how-long-you-should-walk-your-dog.jpg?v=1695834014&width=1920" },
    { "name": "Paseo grupal", "description": "Paseo grupal de una hora", "price": "150", "imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlRVFWhTKk5-jTvJzCCkI29-9DpV98u42l1El9TFuHSQ&s" },
    { "name": "Clicker", "description": "Herramienta de entrenamiento", "price": "72", "imageUrl": "https://t2.ea.ltmcdn.com/es/posts/4/2/0/cargar_el_clicker_del_perro_en_el_adiestramiento_20024_orig.jpg" },
    { "name": "Arnes de entrenamiento", "description": "Arnes especial para entrenamiento", "price": "349", "imageUrl": "https://centrointegralcanino.com.mx/wp-content/uploads/2021/05/elige-la-perchera-o-arnes-para-tu-perro.jpg" },
    { "name": "Correa de entrenamiento", "description": "Correa especial para entrenamiento", "price": "299", "imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1iQinQBMVXRaBLWy4W1G4ca799zmhPzuLq8GMNP8ETw&s" },
    { "name": "Tapete olfativo para perros", "description": "Estimula el olfato del perro", "price": "150", "imageUrl": "https://http2.mlstatic.com/D_NQ_NP_812030-MLM48989094130_012022-O.webp" }
];

// Función para generar las tarjetas de productos
function generateProductCards(products) {
    const productCards = products.map((product, index) => `
        <div class="card pt-3 m-auto" style="width: 18rem;">
            <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}" style="width: 240px; height: 170px;">
            <div class="card-body">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">${product.description}</p>
                <p class="card-text">Precio: $${product.price}</p>
                <button class="btn btn-primary" onclick="addToCart(${index})">Agregar</button>
            </div>
        </div>
    `).join('');

    document.getElementById('productCards').innerHTML = productCards;
}

// Función para agregar productos al carrito
function addToCart(index) {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.push(products[index]);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartCount();
}

// Función para actualizar el contador del carrito
function updateCartCount() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    document.getElementById('cart-count').textContent = cart.length;
}

// Generar las tarjetas de productos al cargar la página
window.onload = function () {
    generateProductCards(products);
    updateCartCount();
};

// Función para mostrar el carrito
function toggleCart(event) {
    event.preventDefault(); // Evita que se ancle a la URL con un #
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const cartModal = document.getElementById('cart-modal');
    const cartItems = document.getElementById('cart-items');

    // Vacía el contenido del modal del carrito
    cartItems.innerHTML = '';

    if (cart.length === 0) {
        cartItems.innerHTML = '<p>El carrito está vacío.</p>';
    } else {
        const cartHTML = cart.map((item, index) => `
    <div class="cart-item">
        <div>
            <p>${item.name}</p>
            <p>Precio: $${item.price}</p>
            <button class="btn btn-sm btn-danger" onclick="removeFromCart(${index})">Eliminar</button>
        </div>
    </div>
`).join('');

        cartItems.innerHTML = cartHTML;
    }

    // Muestra u oculta el modal del carrito sin bloquear la interacción con la página principal
    const bsModal = new bootstrap.Modal(cartModal, { backdrop: false });
    bsModal.show();
}


// Función para eliminar productos del carrito
function removeFromCart(index) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart = cart.filter((_, i) => i !== index);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartCount();
    // Actualiza el contenido del modal del carrito directamente
    const cartItems = document.getElementById('cart-items');
    if (cart.length === 0) {
        cartItems.innerHTML = '<p>El carrito está vacío.</p>';
    } else {
        const cartHTML = cart.map((item, index) => `
            <div class="cart-item">
                <img src="${item.imageUrl}" alt="${item.name}" style="width: 50px; height: 50px;">
                <div>
                    <p>${item.name}</p>
                    <p>Precio: $${item.price}</p>
                    <button class="btn btn-sm btn-danger" onclick="removeFromCart(${index})">Eliminar</button>
                </div>
            </div>
        `).join('');
        cartItems.innerHTML = cartHTML;
    }
}

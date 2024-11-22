
import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
  const [products, setProducts] = useState([]);
  //call api, fetch product data
  useEffect(() => {
    fetch('http://localhost:8080/api/products')
    .then(response => response.json())
    .then(data => setProducts(data));
  }, []);
  return (
    <div className='container'>
      <div>
        {products.length ? (
          <ProductList products={products}/>
        ) : (
          <p>No products found</p>
        )}
      </div>
    </div>
  )
}

export default App

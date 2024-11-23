
import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCateories] = useState([]);
  const [selectedCategories, setSelectedCategories] = useState(null);
  const [searchTerm, setsetSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");
  //call api, fetch product data
  useEffect(() => {
    fetch('http://localhost:8080/api/products')
    .then(response => response.json())
    .then(data => setProducts(data));

    fetch('http://localhost:8080/api/categories')
    .then(response => response.json())
    .then(data => setCateories(data));
  }, []);

  const handleSearchChange = (event) => {
    setsetSearchTerm(event.target.value);
  };
  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };
  const handleCategorySelect = (categoryId) => {
    setSelectedCategories(categoryId ? Number(categoryId) : null);
  };


  return (
    <div className='container'>
      <h1 className='my-4'>Product Catalog</h1>
      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}></CategoryFilter>
        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type='text' className='form-control' placeholder='searhc for products' onChange={handleSearchChange}></input>
        </div>
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort by Price: Low to High</option>
            <option value="desc">Sort by Price: High to Low</option>
          </select>
        </div>
      </div>
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

import { Injectable } from '@angular/core';
import { Product } from './product';
@Injectable()
export class ProductService {
  products: Array<Product> = [
    new Product(0, 'Keyboard', 'Corsair', 129.99, 500),
    new Product(1, 'Mouse', 'Corsair', 59.99, 500)
  ]
  constructor() { }
  getProducts(){
    return this.products;
  }
  addProduct(product){
    this.products.push(product);
  }
  deleteProduct(product){
    this.products.splice(product.id, 1);
  }
}

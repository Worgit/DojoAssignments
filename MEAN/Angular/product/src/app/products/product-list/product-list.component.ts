import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../product-service.service';
import { Product } from '../../product';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  constructor(private _productService: ProductService) { }
  products: Array<Product>;

  ngOnInit() {
    this.getProducts();
  }
  getProducts(){
    this.products = this._productService.getProducts();
    console.log(this.products);
  }
}

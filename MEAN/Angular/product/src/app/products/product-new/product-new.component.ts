import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../product-service.service';
import { Product } from '../../product';

@Component({
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css']
})
export class ProductNewComponent implements OnInit {
  constructor(private _productService: ProductService) { }
  product: Product = new Product;
  index: number = 2;
  ngOnInit() {
  }
  onSubmit(){
    this.product.id = this.index;
    this._productService.addProduct(this.product);
    this.index++;
  }
  onDelete(id){
    this._productService.deleteProduct(id);
  }

}

export class Product{
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  date_created: Date = new Date();
  date_updated: Date = new Date();
  constructor(id: number = 0, name: string = "", description: string = "", price: number = 0.00, quantity: number = 0){
   this.name = name;
   this.description = description;
   this.price = price;
   this.quantity = quantity;
  }
}

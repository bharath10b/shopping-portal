import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products: any;

  constructor(private http: HttpClient) { }

    ngOnInit() {      
        this.http.get<any>('http://localhost:8080/item/list').subscribe(data => {
            //this.totalAngularPackages = data.total;
            this.products = data;
        })
    }

    add() {
      
    }
}
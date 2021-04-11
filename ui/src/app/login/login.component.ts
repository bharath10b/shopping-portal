import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({templateUrl: 'login.component.html'})
export class LoginComponent implements OnInit {
    public loginForm: FormGroup;

    constructor(
        private http: HttpClient,
        private router: Router,
    ) {
        
    }

    ngOnInit() {

        this.loginForm = new FormGroup({
            'username': new FormControl('', [
              Validators.required
            ]),
            'password': new FormControl('', [
              Validators.required
            ])
          });
    }

    public sendLogin() {

        const val = this.loginForm.value;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        const username = val.username;
        const name = val.username;
        const password = val.password;
        this.http.post<any>(`http://localhost:8080/user/login`, { name, username,  password }).subscribe(data => {
            if(data.authenticated == true){
                this.router.navigate(["/item/list"]);
            } else {
                window.alert("user not authenticated");
            }
            //this.router.navigate(["/"]);
        }
        );
    }
}

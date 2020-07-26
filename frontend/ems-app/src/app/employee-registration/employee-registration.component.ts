import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {

  employee: Employee;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    let employeeId = this.route.snapshot.paramMap.get("id");
    if(+employeeId > 0){
      this.employeeService.get(+employeeId).subscribe(employee => this.employee = employee);
    }else{
      this.employee = {id: undefined, name: "", code : "", designation: ""};
    }
  }

  save(): void {
    this.employeeService.save(this.employee).subscribe(id => this.router.navigateByUrl("/employee/list"));
}
}

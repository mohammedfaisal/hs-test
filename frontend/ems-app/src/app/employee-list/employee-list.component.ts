import { Component, OnInit } from '@angular/core';
import { Employee} from './../employee';
import { EmployeeService} from './../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor(
    private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.employeeService.getAll().subscribe(empList => this.employees = empList);
  }

  delete(id: number): void{
    let result = window.confirm("Do you want to delete employee ?");
    if(result){
      this.employeeService.delete(id).subscribe(result => window.location.reload());
    }
  }
}

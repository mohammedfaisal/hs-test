import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private readonly getUrl: string = '/ems/employee/';
  private readonly saveUrl: string = '/ems/employee/save';
  private readonly getAllUrl: string = '/ems/employee/list';
  private readonly deleteUrl: string = '/ems/employee/delete/';
  
  constructor(private http: HttpClient) { }

  get(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.getUrl+id);
  }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.getAllUrl);
  }

  save(employee: Employee): Observable<number> {
    return this.http.post<number>(this.saveUrl, JSON.stringify(employee), {headers: {'Content-Type' : 'application/json'}});
  }

  delete(id: number): Observable<any> {
    return this.http.post(this.deleteUrl+id, {});
  }
}

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'attendanceStatus'
})
export class AttendanceStatusPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    return (value == 1 ? "In Only" : "Complete");
  }

}

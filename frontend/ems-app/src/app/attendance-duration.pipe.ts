import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'attendanceDuration'
})
export class AttendanceDurationPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {    
    
    let mins: number = value % 3600;
    let hour: number = (value - mins) / 3600;
    let secs: number = mins % 60;
    mins = (mins - secs) / 60;

    let hourTxt = (hour > 9 ? hour : "0"+hour);
    let minsTxt = (mins > 9 ? mins : "0"+mins);
    let secsTxt = (secs > 9 ? secs : "0"+secs);

    return `${hourTxt}:${minsTxt}:${secsTxt}`;
  }

}

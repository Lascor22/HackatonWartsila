export class OfficeObjectDTO {
  id: number;
}

export class EmployeeDTO extends OfficeObjectDTO {
  // id: number;
  name: string;
}

export class WorkingTableDTO extends OfficeObjectDTO {
  // id: number;
}

export class WorkingRoomDTO extends OfficeObjectDTO {
  // id: number;
  employees: EmployeeDTO[];
  workingTables: WorkingTableDTO[];
}

export class EventDTO extends OfficeObjectDTO {
  name: string;
  description: string;
  creator: EmployeeDTO;
  employeeList: EmployeeDTO[];
}

export class EventForm {
  public objectMap: WorkingRoomDTO;
  constructor(roomNumber: number,
              public creator: string,
              public name: string,
              public description: string) {
  }
}

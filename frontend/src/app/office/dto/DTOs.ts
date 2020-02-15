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
  id: number;
  employees: EmployeeDTO[];
  workingTables: WorkingTableDTO[];
}

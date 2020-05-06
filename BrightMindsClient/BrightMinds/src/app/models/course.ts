import { Instructor } from './Instructor'

export class Course{
    public id:number
    public instructorId:Instructor
    public hours:number
    public price:number
    public title:string
    public description:string
    public status:number
    public createdAt:string
    public updatedAt:string

    constructor(id:number, instructorId:Instructor, hours:number, price:number, title:string, description:string, 
        status:number, createdAt:string, updatedAt:string){
        this.id = id;
        this.instructorId = instructorId;
        this.hours = hours;
        this.price = price;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
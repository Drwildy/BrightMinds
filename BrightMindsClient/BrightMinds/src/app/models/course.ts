import { Instructor } from './instructor';

export class Course {
    public id:number
    public instructorId:Instructor
    public hours:number
    public price:number
    public title:string
    public description:string
    public status:number
    public createdAt:number
    public updatedAt:number

    constructor(id:number, instructorId:Instructor, hours:number, price:number, title:string, description:string, 
        status:number, createdAt:number, updatedAt:number){
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

    public getId():number{
        return this.id;
    }
    
    public setId(id:number){
        this.id = id;
    }

    public getIntructorId():Instructor{
        return this.instructorId;
    }

    public setIntructorId(instructorId:Instructor){
        this.instructorId = instructorId;
    }

    public getHours():number{
        return this.hours;
    }

    public setHours(hours:number){
        this.hours = hours;
    }

    public getPrice():number{
        return this.price;
    }

    public setPrice(price:number){
        this.price = price;
    }

    public getTitle():string{
        return this.title;
    }

    public setTitle(title:string){
        this.title = title;
    }

    public getDescription():string{
        return this.description;
    }

    public setDescription(description:string){
        this.description = description;
    }

    public getStatus():number{
        return this.status;
    }

    public setStatus(status:number){
        this.status = status;
    }

    public getCreatedAt():number{
        return this.createdAt;
    }

    public setCreatedAt(createdAt:number){
        this.createdAt = createdAt;
    }

    public getUpdatedAt():number{
        return this.updatedAt;
    }

    public setUpdatedAt(updatedAt:number){
        this.updatedAt = updatedAt;
    }
}

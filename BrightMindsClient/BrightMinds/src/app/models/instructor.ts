import { User } from './user';

export class Instructor {
    public id:number;
    public userId:User;
    public firstName:string;
    public lastName:string;
    public phoneNumber:string;
    public address:string;
    public DOB:number;
    public degree:string;
    public status:number;
    public createdAt:number;
    public updatedAt:number;

    constructor( id:number, userId:User, firstName:string, lastName:string, phoneNumber:string,
        address:string, DOB:number, degree:string, status:number, createdAt:number, UpdatedAt:number){
            this.id = id;
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.DOB = DOB;
            this.degree = degree;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = UpdatedAt;
    }

    public getId():number{
        return this.id;
    }
    
    public setId(id:number){
        this.id = id;
    }

    public getUserId():User{
        return this.userId;
    }

    public setUserId(userId:User){
        this.userId = userId;
    }

    public getFirstName():string{
        return this.firstName;
    }

    public setFirstName(firstName:string){
        this.firstName=firstName;
    }

    public getLastName():string{
        return this.lastName;
    }

    public setLastName(lastName:string){
        this.lastName = lastName;
    }

    public getPhoneNumber():string{
        return this.phoneNumber;
    }

    public setPhoneNumber(phoneNumber:string){
        this.phoneNumber = phoneNumber
    }

    public getAddress():string{
        return this.address;
    }

    public setAddress(address:string){
        this.address = address;
    }

    public getDegree():string{
        return this.degree;
    }

    public setDegree(degree:string){
        this.degree = degree;
    }

    public getDOB():number{
        return this.DOB;
    }

    public setDOB(DOB:number){
        this.DOB = DOB;
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
